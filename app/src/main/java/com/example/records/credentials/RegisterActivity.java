package com.example.records.credentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.records.R;
import com.example.records.credentials.data.UserDao;
import com.example.records.credentials.data.UserDatabase;

import model.User;

public class RegisterActivity extends AppCompatActivity {

    EditText name_ed, email_ed, password_ed;
    Button reg_btn, loginIntentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name_ed = (EditText) findViewById(R.id.name_usr_reg);
        email_ed = (EditText) findViewById(R.id.email_usr_reg);
        password_ed = (EditText) findViewById(R.id.password_usr_reg);

        reg_btn = (Button) findViewById(R.id.reg_btn);
        loginIntentButton = (Button) findViewById(R.id.loginIntent);


        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username_register = name_ed.getText().toString();
                String email_register = email_ed.getText().toString();
                String password_register = password_ed.getText().toString();

                User user = new User(username_register,email_register,password_register);

                if(isValidate(user)){
                   UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                   UserDao userDao = userDatabase.userDao();
                   new Thread(new Runnable() {
                       @Override
                       public void run() {
                           userDao.insertUser(user);

                           runOnUiThread(new Runnable() {
                               @Override
                               public void run() {
                                   Toast.makeText(getApplicationContext(),"Registered",Toast.LENGTH_SHORT).show();

                               }
                           });


                       }
                   }).start();

               }else{
                   Toast.makeText(getApplicationContext(), "Enter the Required Fields", Toast.LENGTH_SHORT).show();
               }


            }
        });



        loginIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginScreenIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginScreenIntent);
                finish();
            }
        });

    }

    private Boolean isValidate(User user){
        if(user.getEmail_id().isEmpty() || user.getUsername().isEmpty() || user.getPassword().isEmpty()){
            return false;
        }

        return true;
    }



}