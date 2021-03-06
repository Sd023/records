package com.example.records.credentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.records.DashboardActivity;
import com.example.records.R;
import com.example.records.data.UserDao;
import com.example.records.data.UserDatabase;

import model.User;

public class LoginActivity extends AppCompatActivity {

    EditText email_input, password_input;
    Button login_button,login_reg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_input = findViewById(R.id.email_usr_login);
        password_input = findViewById(R.id.password_usr_login);
        login_button = findViewById(R.id.login_button);
        login_reg = findViewById(R.id.reg_login);


        login_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               final String email_id = email_input.getText().toString();
               final String password = password_input.getText().toString();

                if(email_id.isEmpty() || password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Fill the required fields ", Toast.LENGTH_LONG).show();
                }else{

                    UserDatabase userDatabase = UserDatabase.getDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            User user = userDao.login(email_id,password);

                            if(user == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            else{
                                String name = user.getUsername();
                                String email = user.getEmail_id();
                                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                                Bundle extras = new Bundle();
                                extras.putString("EMAIL_ID", email);
                                extras.putString("USER_NAME",name);
                                intent.putExtras(extras);
                                startActivity(intent);
                                finish();

                            }

                        }

                    }).start();

                }

            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MyShare",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", email_input.getText().toString());
        editor.putString("password",password_input.getText().toString());
        editor.apply();
        Log.v("SharedPreferences", "onPause Called");

        Log.v("id", String.valueOf(email_input));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences = getSharedPreferences("MyShare", MODE_PRIVATE);
        SharedPreferences.Editor  editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        Log.v("SharedPreferences","OnDestroy Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MyShare",MODE_PRIVATE);
        String s1 = sh.getString("name","");
        String s2 = sh.getString("password","");
        email_input.setText(s1);
        password_input.setText(s2);
        Log.v("SharedPreferences","onResume called");
    }
}