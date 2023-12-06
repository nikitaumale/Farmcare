package com.example.farmcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Fertilizeres_SeedsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizeres_seeds);

        CardView fertilizers=findViewById(R.id.cardFertilizers);
        fertilizers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(Fertilizeres_SeedsActivity.this,Fertilizeres_Seeds_list_Activity.class);
                it.putExtra("title","Fertilizers");
                startActivity(it);
            }
        });
        CardView seeds=findViewById(R.id.cardSeeds);
        seeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(Fertilizeres_SeedsActivity.this,Fertilizeres_Seeds_list_Activity.class);
                it.putExtra("title","Seeds");
                startActivity(it);
            }
        });
    }
}