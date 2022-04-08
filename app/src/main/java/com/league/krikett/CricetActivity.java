package com.league.krikett;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CricetActivity extends AppCompatActivity {

    TextView textViewTit,textViewHom,textViewResa,textViewAWe,textViewSted,textViewDat,textViewStat;
    Button buttonback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cricketactivity);

        textViewTit = findViewById(R.id.textViewTit);
        textViewHom = findViewById(R.id.textViewHom);
        textViewResa = findViewById(R.id.textViewResa);
        textViewAWe = findViewById(R.id.textViewAWe);
        textViewSted = findViewById(R.id.textViewSted);
        textViewDat = findViewById(R.id.textViewDat);
        textViewStat = findViewById(R.id.textViewStat);
        buttonback = findViewById(R.id.buttonback);

        textViewTit.setText(getIntent().getStringExtra("title"));
        textViewHom.setText(getIntent().getStringExtra("home"));
        textViewResa.setText(getIntent().getStringExtra("result"));
        textViewAWe.setText(getIntent().getStringExtra("awey"));
        textViewSted.setText(getIntent().getStringExtra("stadium"));
        textViewDat.setText(getIntent().getStringExtra("data"));
        textViewStat.setText(getIntent().getStringExtra("status"));

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
