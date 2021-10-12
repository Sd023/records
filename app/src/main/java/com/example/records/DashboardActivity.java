package com.example.records;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.records.databinding.ActivityDashboardBinding;
import com.example.records.gridviewActivities.CourseActivity;
import com.example.records.gridviewActivities.ProfileActivity;

import Adapter.CustomAdapter;

public class DashboardActivity extends AppCompatActivity {

    TextView textView;
    ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("USER_NAME");
       textView = (TextView) findViewById(R.id.disp_name);
        textView.setText(username);

        String [] itemNames = {"Profile", "TO-DO" , "Home", "Marks", "Courses", "Settings"};
        int[] images = {R.drawable.ic_outline_person_24,R.drawable.check, R.drawable.h, R.drawable.f, R.drawable.b, R.drawable.s};

        CustomAdapter customAdapter = new CustomAdapter(DashboardActivity.this, itemNames, images);

        binding.gridView.setAdapter(customAdapter);

        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(isProfile(i)){
                    Intent newIntent = new Intent(DashboardActivity.this, ProfileActivity.class);
                    Bundle bundle = getIntent().getExtras();
                    if (bundle != null) {
                        newIntent.putExtras(bundle);
                    }
                    startActivity(newIntent);

                }
                else if(isToDo(i)){
                    Toast.makeText(getApplicationContext(), "TO-DO", Toast.LENGTH_SHORT).show();
                }else if(isHome(i)){
                    Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                }else if(isMarks(i)){
                    Toast.makeText(getApplicationContext(), "Marks", Toast.LENGTH_SHORT).show();
                }else if(isCourses(i)){
                   Intent intent = new Intent(DashboardActivity.this,CourseActivity.class);
                   startActivity(intent);
                }else if(isSettings(i)){
                    Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }

    public Boolean isProfile(int position){
        return position == 0;
    }
    public Boolean isToDo(int position){
        return position ==1;
    }
    public Boolean isHome(int position){
        return position ==2;
    }
    public Boolean isMarks(int position){
        return position ==3;
    }
    public Boolean isCourses(int position){
        return position ==4;
    }
    public Boolean isSettings(int position){
        return position==5;
    }


}