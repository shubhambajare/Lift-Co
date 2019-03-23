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

public class giver extends AppCompatActivity {

    EditText from,to;
    TextView vehicleno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giver);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Button search=(Button)findViewById(R.id.search);
        from=(EditText)findViewById(R.id.from);
        to=(EditText)findViewById(R.id.to);
        vehicleno=(TextView)findViewById(R.id.vehicleno);
        vehicleno.setText(profile.vehiclenumber);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=from.getText().toString();
                String b= to.getText().toString();

                OkHttpClient client=new OkHttpClient();
                String url ="https://trskncoe.000webhostapp.com/liftme/give.php?id="+profile.id+"&from="+a+"&to="+b;

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
                            giver.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    if(myresponce.equals("111"))
                                        profile.msg="No one want right lift now for this route";
                                    else
                                        profile.msg=myresponce;

                                    Intent  i=new Intent(giver.this,giver1.class);
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
