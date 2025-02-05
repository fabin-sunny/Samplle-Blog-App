package com.example.blogapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    AppCompatButton b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        SharedPreferences pref=getSharedPreferences("logged",MODE_PRIVATE);

        String username=pref.getString("user",null);
        if(username!=null)
        {
            Intent i=new Intent(getApplicationContext(), SigninPage.class);
            startActivity(i);
        }
        ed1=(EditText) findViewById(R.id.uname);
        ed2=(EditText) findViewById(R.id.pass);
        b1=(AppCompatButton) findViewById(R.id.signin);
        b2=(AppCompatButton) findViewById(R.id.signup);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getUsername=ed1.getText().toString();
                String getPass=ed2.getText().toString();
                if(getUsername.equals("admin")&&getPass.equals("12345"))
                {
                    SharedPreferences pref=getSharedPreferences("logged",MODE_PRIVATE);
                    SharedPreferences.Editor editor= pref.edit();
                    editor.putString("user","admin");
                    editor.apply();
                    Intent i=new Intent(getApplicationContext(), SigninPage.class);
                    startActivity(i);
                }
                else
                {

                    Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_SHORT).show();
                }


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),SignupPage.class);
                startActivity(i);
            }
        });

    }
}