package com.example.findmyage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Admin.login;

public class LoginActivity extends AppCompatActivity {
    private TextView txtLogin, registerUser, admin;
    private Button btnLogin;
    private EditText userName, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView registerUser = findViewById(R.id.textViewExistingUser);
        TextView txtLogin = findViewById(R.id.textViewLogin);
        EditText useName = findViewById(R.id.editTextRegisterUserName);
        TextView admin = findViewById(R.id.admin);
        EditText Password = findViewById(R.id.editTextRegisterPassword);
        btnLogin= findViewById(R.id.buttonRegister);


        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                registerUser.setTextColor(Color.BLACK);

            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String username = useName.getText().toString();
               String password = Password.getText().toString();
                Database db = new Database(getApplicationContext(),"Healthcare", null, 1);
               if (username.length()==0 || password.length()==0){
                   Toast.makeText(LoginActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
               }else
                   if (db.login(username,password)==1){
                       Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                       SharedPreferences sharedPreferences = getSharedPreferences("share_prefs", Context.MODE_PRIVATE);
                       SharedPreferences.Editor editor = sharedPreferences.edit();
                       editor.putString("username", username);
                       // save data with key and value
                       editor.apply();
                       startActivity( new Intent( LoginActivity.this, HomeActivity.class));

                   }

            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, login.class);
                startActivity(intent);
            }
        });
    }

}