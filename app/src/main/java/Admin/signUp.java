package Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.findmyage.R;

import upload.AddDetails;

public class signUp extends AppCompatActivity {
private TextView haveAccount, done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextView haveAccount = findViewById(R.id.textViewExistingUser);
        haveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(signUp.this, login.class);
                startActivity(intent);
            }
        });
    }

    public void done(View view) {
        Intent intent = new Intent(signUp.this, AddDetails.class);
        startActivity(intent);
    }
}