package com.example.clash.demo11;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class login2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button next=(Button)findViewById(R.id.next);
        final EditText otp=(EditText)findViewById(R.id.otp);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String o=otp.getText().toString();
                if(o.equals(profile.otp)) {
                    Intent i = new Intent(login2.this, login3.class);
                    finish();
                    startActivity(i);
                }
                else {
                    Toast.makeText(login2.this,"Wrong otp",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
