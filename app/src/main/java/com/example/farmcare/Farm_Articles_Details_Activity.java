package com.example.farmcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Farm_Articles_Details_Activity extends AppCompatActivity {
    TextView tv;
    EditText ed;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_articles_details);

        btn=findViewById(R.id.buttonBack);
        tv=findViewById(R.id.textViewATitle);
        ed=findViewById(R.id.editTextADetail);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Farm_Articles_Details_Activity.this,Farm_Articles_Activity.class));
            }
        });

        Intent intent=getIntent();
        tv.setText(intent.getStringExtra("text1"));
        ed.setText(intent.getStringExtra("text2"));


    }
}