package com.example.phamducmanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edUser;
    private EditText edDes;
    private EditText edMail;
    private Button btnFeedback;
    private CheckBox checkBox;
    private Spinner spinner;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=AppDatabase.getAppDatabase(this);
        init();
    }
    private void init(){

        edUser = findViewById(R.id.edUser);
        edDes = findViewById(R.id.edDes);
        edMail=findViewById(R.id.edMail);
        btnFeedback = findViewById(R.id.btnFeedBack);
        checkBox = findViewById(R.id.ck);
        spinner = findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gripe, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        btnFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveTask();

            }
        });
    }
    private void SaveTask() {
        final String user = edUser.getText().toString().trim();
        final String mail = edMail.getText().toString().trim();
        final String des = edDes.getText().toString().trim();
        final String gripe = spinner.getSelectedItem().toString();
        if (user.isEmpty()) {
            edUser.setError("Task required");
            edUser.requestFocus();
            return;
        }
        if (mail.isEmpty()) {
            edMail.setError("Task required");
            edMail.requestFocus();
            return;
        }
        if (des.isEmpty()) {
            edDes.setError("Task required");
            edDes.requestFocus();
            return;
        }
        if (!checkBox.isChecked()) {
            Toast.makeText(this, "You have not agreed to send emails", Toast.LENGTH_LONG).show();
            return;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user);
        userEntity.setMail(mail);
        userEntity.setDes(des);
        userEntity.setGripe(gripe);
        db.userDAO().insertUser(userEntity);
        Toast.makeText(this,"Thêm Mới Thành Công",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this,ListUserActivity.class);
        startActivity(intent);
    }
}