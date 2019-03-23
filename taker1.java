package com.example.clash.demo11;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class taker1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taker1);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final TextView result=(TextView)findViewById(R.id.result);
        final Button stop=(Button)findViewById(R.id.stop);
        final Button finish=(Button)findViewById(R.id.finish);

        finish.setClickable(false);
        finish.setVisibility(View.INVISIBLE);

        CountDownTimer c=new CountDownTimer(40000,2000) {
            @Override
            public void onTick(long millisUntilFinished) {

                OkHttpClient client=new OkHttpClient();
                String url ="https://trskncoe.000webhostapp.com/liftme/exchange.php?id="+profile.id;

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
                            taker1.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if(myresponce.equals("notmatch")){

                                    }
                                    else{
                                        result.setText(myresponce);
                                        stop.setClickable(false);
                                        stop.setVisibility(View.INVISIBLE);
                                        finish.setClickable(true);
                                        finish.setVisibility(View.VISIBLE);
                                        cancel();
                                    }
                                }
                            });

                        }
                    }
                });
            }

            @Override
            public void onFinish() {
                start();

            }
        }.start();


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient client=new OkHttpClient();
                String url ="https://trskncoe.000webhostapp.com/liftme/stop.php?id="+profile.id;

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
                            taker1.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                }
                            });

                        }
                    }
                });


                finish();
                Intent i=new Intent(taker1.this,select.class);
                startActivity(i);

            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OkHttpClient client=new OkHttpClient();
                String url ="https://trskncoe.000webhostapp.com/liftme/finish.php?id="+profile.id;

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
                            taker1.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    finish();
                                    Intent  i=new Intent(taker1.this,select.class);
                                    startActivity(i);

                                }
                            });

                        }
                    }
                });
            }
        });

    }

}
