package com.example.anthony.a20.Student;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.anthony.a20.Entities.Profesor;
import com.example.anthony.a20.R;

public class StudentActivity extends AppCompatActivity implements CVTeacherFragment.OnFragmentInteractionListener, StudentProfileFragment.OnFragmentInteractionListener  ,ProfesorHomeFragment.OnListFragmentInteractionListener{

    private TextView mTextMessage;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment=null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment=new ProfesorHomeFragment();break;
                case R.id.navigation_tutorias:
                    break;
                case R.id.navigation_favoritos:
                    break;
                case R.id.navigation_mensajes:
                    break;
                case R.id.navigation_profile:
                    fragment=new StudentProfileFragment();break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Fragment fragment=null;
        fragment= new ProfesorHomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(Profesor item) {

    }
}
