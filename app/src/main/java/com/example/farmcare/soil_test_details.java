package com.example.farmcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class soil_test_details extends AppCompatActivity {

    TextView tvPackageName,tvTotalCost,tvFirmName;
    EditText edDetails;
    Button btnBuyTest,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil_test_details);

        tvPackageName=findViewById(R.id.textViewSTDTitle);
        tvTotalCost=findViewById(R.id.textViewSTDTotalCost);
        edDetails=findViewById(R.id.editTextSTDTestDetail);
        btnBuyTest=findViewById(R.id.buttonBuyTest);
        btnBack=findViewById(R.id.buttonSTDBack);
        tvFirmName=findViewById(R.id.textViewSTDFirmName);

        edDetails.setKeyListener(null);

        Intent intent=getIntent();
        tvFirmName.setText(intent.getStringExtra("text1"));
        tvPackageName.setText(intent.getStringExtra("text2"));
        edDetails.setText(intent.getStringExtra("text4"));
        tvTotalCost.setText("Total Cost : "+intent.getStringExtra("text3")+"/-");
        String firmname=tvFirmName.getText().toString();
        String pkgName=tvPackageName.getText().toString();
        String cost=intent.getStringExtra("text3");

        btnBuyTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(soil_test_details.this,Buy_test.class);
                it.putExtra("text1",firmname);
                it.putExtra("text2",pkgName);
                it.putExtra("text3",cost);
                startActivity(it);
            }
        });
    }
}