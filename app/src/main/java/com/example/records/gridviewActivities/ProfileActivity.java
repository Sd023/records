package com.example.records.gridviewActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.records.R;
import com.example.records.credentials.RegisterActivity;
import com.example.records.credentials.data.UserDao;
import com.example.records.credentials.data.UserDatabase;
import com.squareup.picasso.Picasso;

import model.User;

public class ProfileActivity extends AppCompatActivity {

    TextView email_view, name_view;
    EditText nameUpdate_txt,emailUpdate_txt;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("USER_NAME");
        String email_id = bundle.getString("EMAIL_ID");

        email_view = (TextView) findViewById(R.id.txt_email);
        name_view = (TextView) findViewById(R.id.txt_name);
        nameUpdate_txt = (EditText)findViewById(R.id.name_update_text);
        emailUpdate_txt=(EditText)findViewById(R.id.email_update);

        name_view.setText(name);
        email_view.setText(email_id);
        imageView = (ImageView)findViewById(R.id.profile_image);
        Picasso.get().load(R.drawable.avatar).into(imageView);

        name_view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                name_view.setVisibility(View.GONE);
                nameUpdate_txt.setVisibility(View.VISIBLE);
                return false;

            }
        });

        email_view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                email_view.setVisibility(View.GONE);
                emailUpdate_txt.setVisibility(View.VISIBLE);
                return false;
            }
        });

    }


}