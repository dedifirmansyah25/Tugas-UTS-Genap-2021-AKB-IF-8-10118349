/*
03 JUNI 2021
10118349
Dedi firmansyah
IF8
*/
package com.example.myprofile_10118349;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMain();
            }
        });
    }

    public void toMain(){
        Intent i = new Intent(home.this, MainActivity.class);
        startActivity(i);
    }
}