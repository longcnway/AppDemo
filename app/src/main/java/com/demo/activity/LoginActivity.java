package com.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private EditText username;
    private EditText password;
    private Button bt_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("TAG=============", "onCreate: -----------------");
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        bt_login = (Button) findViewById(R.id.login_button);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameStr = username.getText().toString().trim();
                String passportStr = password.getText().toString().trim();
                if("admin".equals(usernameStr) && "123456".equals(passportStr)){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "login faild !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}