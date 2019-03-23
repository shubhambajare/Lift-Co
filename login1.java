package com.example.clash.demo11;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class login1 extends AppCompatActivity {

    Button next;
    EditText Name,Age,Phone,Vnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        next=(Button)findViewById(R.id.next);
        Name=(EditText)findViewById(R.id.name);
        Age=(EditText)findViewById(R.id.age);
        Phone=(EditText)findViewById(R.id.phone);
        Vnumber=(EditText)findViewById(R.id.vnumber);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                profile.name=Name.getText().toString();
                profile.age=Age.getText().toString();
                profile.phonenumber=Phone.getText().toString();
                profile.vehiclenumber=Vnumber.getText().toString();


                OkHttpClient client=new OkHttpClient();
                String url ="https://trskncoe.000webhostapp.com/liftme/otp.php?phone="+profile.phonenumber;

                Request request=new Request.Builder()
                        .url(url)
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
//                        Toast.makeText(login1.this,"fail",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if(response.isSuccessful()){
                            final String myresponce=response.body().string();
                            login1.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //Toast.makeText(login1.this,myresponce,Toast.LENGTH_LONG).show();
                                profile.otp=myresponce;
                                }
                            });

                        }
                    }
                });

                Intent i=new Intent(login1.this,login2.class);
                finish();
                startActivity(i);
            }
        });
    }
}
