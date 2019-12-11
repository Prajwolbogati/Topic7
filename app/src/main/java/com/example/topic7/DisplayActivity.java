package com.example.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DisplayActivity extends AppCompatActivity {
    private ListView lstmeaning;
    private Map<String,String> meaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);



        lstmeaning = findViewById(R.id.lstmeaning);
        meaning = new HashMap<>();
        readFromFile();





        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(meaning.keySet())
        );
lstmeaning.setAdapter(adapter);
lstmeaning.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String key = parent.getItemAtPosition(position).toString();
        String mean = meaning.get(key);
        Intent intent = new Intent(DisplayActivity.this,MeaningActivity.class);
        intent.putExtra("meaning", mean);
        startActivity(intent);


    }
});
        }

    private final void readFromFile() {
        try {
            FileInputStream fos = openFileInput("words.txt");
            InputStreamReader isr = new InputStreamReader(fos);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line=br.readLine()) !=null){
                String[] parts = line.split("-");
                meaning.put(parts[0], parts[1]);

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

