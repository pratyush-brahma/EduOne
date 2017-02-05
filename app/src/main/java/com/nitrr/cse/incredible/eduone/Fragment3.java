package com.nitrr.cse.incredible.eduone;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentActivity;
        import android.support.v7.widget.CardView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.TextView;

        import com.nitrr.cse.incredible.eduone.Courses.CourseReg;
        import com.nitrr.cse.incredible.eduone.Cs.Ds.DsActivity;
        import com.nitrr.cse.incredible.eduone.Login_Register.Login;
        import com.nitrr.cse.incredible.eduone.Login_Register.Session;


public class Fragment3 extends Fragment {

    public Fragment3() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_fragment3, container, false);


        Intent ourintent=new Intent(getContext(),DsActivity.class);
        ourintent.putExtra("key","http://www.geeksforgeeks.org/");
        startActivity(ourintent);




        return v;
    }


}
