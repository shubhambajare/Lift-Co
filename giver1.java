package com.example.clash.demo11;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class giver1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giver1);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final Button finish=(Button)findViewById(R.id.finish);
        TextView result=(TextView)findViewById(R.id.result);
        result.setText(profile.msg);

        if(profile.msg.equals("No one want right lift now for this route")){
            finish.setVisibility(View.INVISIBLE);
            finish.setClickable(false);
        }

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
                            giver1.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    finish();
                                    Intent i=new Intent(giver1.this,select.class);
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
