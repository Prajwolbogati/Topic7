package com.example.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

import static android.widget.Toast.LENGTH_SHORT;

public class AddWordActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etword;
    private EditText etmeaning;
    private Button btnadd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        etword = findViewById(R.id.etword);
        etmeaning = findViewById(R.id.etmeaning);

        btnadd = findViewById(R.id.btnadd);

        btnadd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {

            PrintStream printStream = new PrintStream(openFileOutput("words.txt", MODE_PRIVATE | MODE_APPEND));
            printStream.println(etword.getText().toString() + "-" + etmeaning.getText().toString());
            Toast.makeText(this, "Saved to " + getFilesDir(), LENGTH_SHORT).show();
            //Toast.makeText(this, "Saved to" + getFilesDir(), Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Log.d("Dictionary app", "Error: " + e.toString());
            e.printStackTrace();

        }
    }

}
