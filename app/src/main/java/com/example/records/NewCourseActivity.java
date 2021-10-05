package com.example.records;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewCourseActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "REPLY";
    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_course);
        editText = findViewById(R.id.edit_word);

        button = findViewById(R.id.button_save);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                if(TextUtils.isEmpty(editText.getText())){
                    editText.setError("Required");
                }else{
                    String course = editText.getText().toString();
                    intent.putExtra(EXTRA_REPLY,course);
                    setResult(RESULT_OK,intent);
                }
                finish();
            }
        });

    }
}