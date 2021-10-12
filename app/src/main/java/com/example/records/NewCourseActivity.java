package com.example.records;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewCourseActivity extends AppCompatActivity {

    public static final String TAG = "COURSE";
    public static final String EXTRA_TAG = "STAFF";
    private EditText editText, editText2;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_course);
        editText = findViewById(R.id.edit_word);
        editText2 = findViewById(R.id.edit_word2);

        button = findViewById(R.id.button_save);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                if(TextUtils.isEmpty(editText.getText())){
                    Toast.makeText(getApplicationContext(), "Required", Toast.LENGTH_SHORT).show();
                }else{
                    String course = editText.getText().toString();
                    String staff = editText2.getText().toString();
                    intent.putExtra(TAG,course);
                    intent.putExtra(EXTRA_TAG,staff);
                    setResult(RESULT_OK,intent);
                }
                finish();
            }
        });

    }
}