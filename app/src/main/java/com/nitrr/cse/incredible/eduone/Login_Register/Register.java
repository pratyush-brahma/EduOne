package com.nitrr.cse.incredible.eduone.Login_Register;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.Toast;
        import com.android.volley.AuthFailureError;
        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;
        import com.nitrr.cse.incredible.eduone.MainActivity;
        import com.nitrr.cse.incredible.eduone.R;

        import org.json.JSONException;
        import org.json.JSONObject;
        import java.util.HashMap;
        import java.util.Map;

public class Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private static final String[]paths = {"Director", "Registrar", "Hod","Faculty","Staff"};
    private static final String[]paths2 = {"Cse","Mechanical","Electrical","IT","Civil","Biotech","Biomed","Mining","Metallurgy","Architecture","Electronics","Chemical"};

    String strpos;
    String strdepartment;

    private RequestQueue requestQueue;
    private static final String URL = "http://saurabhshrivas3.esy.es/user_control.php";
    private StringRequest request;
    private Session session;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText user = (EditText) findViewById(R.id.username);

        final EditText pass = (EditText) findViewById(R.id.password);

        final EditText contact = (EditText) findViewById(R.id.contact);
        final EditText email = (EditText) findViewById(R.id.email);
        final Spinner spPosition= (Spinner) findViewById(R.id.spinner);
        final Spinner spDept= (Spinner) findViewById(R.id.spinner2);



        final Button Signupbutton = (Button) findViewById(R.id.SignUPbutton);


        ArrayAdapter<String>adapter = new ArrayAdapter<String>(Register.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPosition.setAdapter(adapter);
        spPosition.setOnItemSelectedListener(this);



        ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(Register.this, android.R.layout.simple_spinner_item,paths2);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDept.setAdapter(adapter2);
        spDept.setOnItemSelectedListener(this);





        requestQueue = Volley.newRequestQueue(this);

        Signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            if(jsonObject.names().get(0).equals("success"))
                            {
                                session.setLoggedin(true);
                                Toast.makeText(getApplicationContext(),"SUCCESS "+jsonObject.getString("success"),Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();

                            }else {
                                Toast.makeText(getApplicationContext(), "Error" +jsonObject.getString("error"), Toast.LENGTH_SHORT).show();
                                pass.setText("");

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String,String> hashMap = new HashMap<String, String>();
                        hashMap.put("name",name.getText().toString());
                        hashMap.put("user",user.getText().toString());
                        hashMap.put("contact",contact.getText().toString());
                        hashMap.put("email",email.getText().toString());
                        hashMap.put("password",pass.getText().toString());

                        hashMap.put("position",strpos.toString());

                        hashMap.put("department",strdepartment.toString());

                        return hashMap;
                    }
                };

                requestQueue.add(request);
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        Spinner spin= (Spinner) parent;

        if(spin.getId()==R.id.spinner) {
            switch (position) {
                case 0:
                    strpos = "Director";

                    break;
                case 1:
                    strpos = "Registrar";
                    // Whatever you want to happen when the second item gets selected
                    break;
                case 2:
                    strpos = "Hod";
                    // Whatever you want to happen when the thrid item gets selected
                    break;

                case 3:
                    strpos = "Faculty";
                    // Whatever you want to happen when the thrid item gets selected
                    break;
                case 4:
                    strpos = "Staff";
                    // Whatever you want to happen when the thrid item gets selected
                    break;
            }

        }


        if(spin.getId()==R.id.spinner2) {
            switch (position) {
                case 0:
                    strdepartment = "Cse";
                    break;
                case 1:
                    strdepartment ="Mechanical" ;
                    break;
                case 2:
                    strdepartment = "Electrical";
                    break;
                case 3:
                    strdepartment = "IT";
                    break;
                case 4:
                    strdepartment = "Civil";
                    break;
                case 5:
                    strdepartment = "Biotech";
                    break;
                case 6:
                    strdepartment = "Biomed";
                    break;
                case 7:
                    strdepartment = "Mining";
                    break;
                case 8:
                    strdepartment = "Metullargy";
                    break;
                case 9:
                    strdepartment = "Architecture";
                    break;
                case 10:
                    strdepartment = "Electronics";
                    break;
                case 11:
                    strdepartment = "Chemical";
                    break;

            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}













