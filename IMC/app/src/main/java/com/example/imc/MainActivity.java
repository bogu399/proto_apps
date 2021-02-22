package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView imc, demo1, demo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imc = (CardView) findViewById(R.id.imc);
        demo1 = (CardView) findViewById(R.id.demo1);
        demo2 = (CardView) findViewById(R.id.demo2);

        imc.setOnClickListener(this);
        demo1.setOnClickListener(this);
        demo2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.imc :
                i = new Intent(this, imcActivity.class);
                startActivity(i);
                break;
            case R.id.demo1 :
                i = new Intent(this, CalcActivity1.class);
                startActivity(i);
                break;
            case R.id.demo2 :
                i = new Intent(this, CalcActivity2.class);
                startActivity(i);
                break;
        }
    }
}