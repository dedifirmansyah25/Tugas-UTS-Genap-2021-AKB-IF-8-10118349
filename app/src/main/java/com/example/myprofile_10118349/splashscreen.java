/*
05 JUNI 2021
10118349
Dedi firmansyah
IF8
*/
package com.example.myprofile_10118349;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class splashscreen extends AppCompatActivity {

    private int waktu_loading = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splashscreen);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent home = new Intent(splashscreen.this, home.class);
                startActivity(home);
                finish();
            }
        }, waktu_loading);
    }
}