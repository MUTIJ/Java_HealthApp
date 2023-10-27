package Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.findmyage.R;

public class login extends AppCompatActivity {
private TextView signupAdmin;
    private Button btnLogin;
    private EditText userName, Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

    }

    public void signupOnClick(View view) {

        Intent intent = new Intent(login.this, signUp.class);
        startActivity(intent);
    }
}