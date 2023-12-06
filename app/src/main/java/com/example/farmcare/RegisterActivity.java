package com.example.farmcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername , edPassword , edEmail , edConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edUsername=findViewById(R.id.editTextRegUsername);
        edPassword=findViewById(R.id.editTextRegPassword);
        edConfirm=findViewById(R.id.editTextRegConfirmPassword);
        edEmail=findViewById(R.id.editTextRegEmail);
        btn=findViewById(R.id.buttonRegister);
        tv=findViewById(R.id.textViewExistingUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edUsername.getText().toString();
                String password=edPassword.getText().toString();
                String confirm=edConfirm.getText().toString();
                String email=edEmail.getText().toString();
                Database db=new Database(getApplicationContext(),"farmcare",null,1);
                if(username.length()==1 || password.length()==0 || email.length()==1 || confirm.length()==0)
                {
                    Toast.makeText(RegisterActivity.this, "Please fill all details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(password.compareTo(confirm)==0)
                    {
                        if(isValid(password))
                        {
                            db.register(username,email,password);
                            Toast.makeText(RegisterActivity.this, "Signup success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "Password must contain 8 characters, having letter ,digit and special symbol", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Password and Confirm password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public static boolean isValid(String passwordhere)
    {
        int f1=0,f2=0,f3=0;
        if(passwordhere.length()<8)
        {
            return false;
        }
        else
        {
            for(int p=0;p<passwordhere.length();p++)
            {
                if(Character.isLetter(passwordhere.charAt(p)))
                {
                    f1=1;
                }
            }
            for(int s=0;s<passwordhere.length();s++)
            {
                if(Character.isDigit(passwordhere.charAt(s)))
                {
                    f2=1;
                }
            }
            for(int r=0;r<passwordhere.length();r++)
            {
                char c=passwordhere.charAt(r);
                if(c>33 && c<=46 || c==64)
                {
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
            {
                return true;
            }
            return false;
        }
    }
}