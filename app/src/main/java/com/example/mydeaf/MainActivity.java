package com.example.mydeaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goDactyl(View v)
    {
        Intent intent = new Intent(this, DactylActivity.class);
        startActivity(intent);
    }

    public void goAlphabet(View v)
    {
        Intent intent = new Intent(this, AlphabetActivity.class);
        startActivity(intent);
    }

    public void goNumber(View v)
    {
        Intent intent = new Intent(this, NumberActivity.class);
        startActivity(intent);
    }

    public void goAcquaintance(View v)
    {
        Intent intent = new Intent(this, AcquaintanceActivity.class);
        startActivity(intent);
    }

    public void goLogin(View v)
    {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void goLeksika(View v)
    {
        Intent intent = new Intent(this, LecksikaActivity.class);
        startActivity(intent);
    }
}