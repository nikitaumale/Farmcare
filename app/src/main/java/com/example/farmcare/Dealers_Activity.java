package com.example.farmcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dealers_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealers);

        CardView vegetables=findViewById(R.id.cardVegetables);
        vegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(Dealers_Activity.this,Dealers_list_Activity.class);
                it.putExtra("title","Vegetables Dealers");
                startActivity(it);
            }
        });

        CardView pulsesandCereals=findViewById(R.id.cardPulsesandCereals);
        pulsesandCereals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(Dealers_Activity.this,Dealers_list_Activity.class);
                it.putExtra("title","Pulses Dealers");
                startActivity(it);
            }
        });

        CardView fruits=findViewById(R.id.cardFruits);
        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(Dealers_Activity.this,Dealers_list_Activity.class);
                it.putExtra("title","Fruits Dealers");
                startActivity(it);
            }
        });

        CardView Others=findViewById(R.id.cardOthers);
        Others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(Dealers_Activity.this,Dealers_list_Activity.class);
                it.putExtra("title","Dealers");
                startActivity(it);
            }
        });
    }
}