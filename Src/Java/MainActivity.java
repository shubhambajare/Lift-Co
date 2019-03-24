package com.example.clash.demo11;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    Boolean flag;
    TextView temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        temp=(TextView)findViewById(R.id.h);
        sharedPreferences=getSharedPreferences("flag",MODE_PRIVATE);
        flag=sharedPreferences.getBoolean("checkflag",false);

        if(flag==false){
        Intent i=new Intent(MainActivity.this,login1.class);
        //finish();
        startActivity(i);
        SharedPreferences.Editor editor=getSharedPreferences("flag",MODE_PRIVATE).edit();
        editor.putBoolean("checkflag",true);
        editor.apply();
        }
       else
        {
            get();
            //finish();
            //temp.setText(profile.name+profile.age+profile.email+profile.vehiclenumber+profile.phonenumber);
            Intent move=new Intent(MainActivity.this,select.class);
            startActivity(move);
        }
    }

    void get(){

        SharedPreferences sharedPreferences1=getSharedPreferences("profile",MODE_PRIVATE);
        profile.name=sharedPreferences1.getString("name","1");
        profile.age=sharedPreferences1.getString("age","1");
        profile.vehiclenumber=sharedPreferences1.getString("vnumber","1");
        profile.phonenumber=sharedPreferences1.getString("phone","1");
        profile.id=sharedPreferences1.getString("id","1");

    }
}


