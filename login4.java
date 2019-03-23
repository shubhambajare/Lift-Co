package com.example.clash.demo11;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class login4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login4);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Button next=(Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(login4.this,MainActivity.class);
                finish();

                startActivity(i);

                OkHttpClient client=new OkHttpClient();
                String url ="https://trskncoe.000webhostapp.com/liftme/insert.php?name="+profile.name+"&phone="+profile.phonenumber
                        +"&vno="+profile.vehiclenumber+"&age="+profile.age;

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
                            login4.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(login4.this,myresponce,Toast.LENGTH_LONG).show();
                                    profile.id=myresponce;
                                    set();
                                }
                            });

                        }
                    }
                });
            }
        });
    }
    void set(){
        SharedPreferences.Editor editor=getSharedPreferences("profile",MODE_PRIVATE).edit();
        editor.putString("name",profile.name);
        editor.putString("age",profile.age);
        editor.putString("vnumber",profile.vehiclenumber);
        editor.putString("phone",profile.phonenumber);
        editor.putString("email",profile.email);
        editor.putString("id",profile.id);
        editor.apply();
      //  Toast.makeText(login4.this,"sett",Toast.LENGTH_LONG).show();
    }
}
