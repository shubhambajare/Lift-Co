package com.example.clash.demo11;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class select extends AppCompatActivity {

    Button take,give,dispro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

     //   Toast.makeText(select.this,profile.name+profile.age+profile.email+profile.vehiclenumber+profile.phonenumber,Toast.LENGTH_LONG).show();

        take=(Button)findViewById(R.id.take);
        give=(Button)findViewById(R.id.give);
        dispro=(Button)findViewById(R.id.dispro);

        dispro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent i = new Intent(select.this,disprofile.class);
                startActivity(i);

            }
        });

        take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(select.this,taker.class);
                startActivity(i1);
            }
        });

        give.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i2=new Intent(select.this,giver.class);
                startActivity(i2);
            }
        });
    }
}
