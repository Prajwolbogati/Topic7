package com.example.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MeaningActivity extends AppCompatActivity {
    private TextView tvmeaning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaning);
        tvmeaning = findViewById(R.id.tvmeaning);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            String mean = bundle.getString("meaning");
            tvmeaning.setText(mean);
        }
    }
}
