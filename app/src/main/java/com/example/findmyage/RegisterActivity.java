package com.example.findmyage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
 private TextView ArrowBack, oldUser;
    private Button btnRegistar;
    private EditText userName,edEmail, edConPassword, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        oldUser=findViewById(R.id.textViewExistingUser);
        btnRegistar= findViewById(R.id.buttonRegister);
        userName =findViewById(R.id.editTextRegisterUserName);
        edEmail=findViewById(R.id.editTextRegisterEmail);
        edConPassword = findViewById(R.id.editTextRegisterConfirmPassword);
        password= findViewById(R.id.editTextRegisterPassword);
        ArrowBack=findViewById(R.id.backArrow);

        oldUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                oldUser.setTextColor(Color.BLACK);

            }
        });

        btnRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = userName.getText().toString();
                String email = edEmail.getText().toString();
                String Password = password.getText().toString();
                String conPassword = edConPassword.getText().toString();

                Database db = new Database(getApplicationContext(),"Healthcare", null, 1);

                if (username.length()==0 || email.length()==0 || Password.length()==0 || conPassword.length()==0 ){
                    Toast.makeText(RegisterActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                }else
                    if (Password.compareTo(conPassword)==0){
                        if (isValid(Password)){
                            db.register(username,email,Password);
                            Toast.makeText(RegisterActivity.this, " Record inserted ", Toast.LENGTH_SHORT).show();
                            startActivity( new Intent(RegisterActivity.this, LoginActivity.class));

                        }else {
                            Toast.makeText(RegisterActivity.this, "Password should contain atleast 8 characters, having letter , digit and special symbol ", Toast.LENGTH_SHORT).show();
                        }

                    }else
                        Toast.makeText(RegisterActivity.this, "Password and confirm Password does not match ", Toast.LENGTH_SHORT).show();
            }
        });


        ArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
    public static boolean isValid( String Passwordhere){
     int f1=0, f2=0, f3=0;
     if (Passwordhere.length() < 8){
         return false;
     }else {
         for ( int p = 0; p< Passwordhere.length(); p++){
            if (Character.isLetter(Passwordhere.charAt(p))){
                f1=1;
            }
         }
         for (int r =0; r <Passwordhere.length(); r++){
             if (Character.isDigit(Passwordhere.charAt(r))){
                 f2=1;
             }
         }
         for (int s = 0; s < Passwordhere.length(); s++){
             char c = Passwordhere.charAt(s);
             if ( c > 33 && c <= 46 || c==64){
                 f3 = 1;
             }
         }
         if (f1== 1 && f2 == 1 && f3 == 1)
             return true;
         return false;
     }
    }
}