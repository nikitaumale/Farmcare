package com.example.farmcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Fertilizeres_Seeds_buy_Activity extends AppCompatActivity {

    EditText edname,edcontact,edaddress,edPrice;
    Button btnBuy;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizeres_seeds_buy);

        edname=findViewById(R.id.editTextFSBFullName);
        edcontact=findViewById(R.id.editTextFSBContact);
        edaddress=findViewById(R.id.editTextFSBAddress);
        edPrice=findViewById(R.id.editTextFSBPrice);
        btnBuy=findViewById(R.id.buttonFSB);
        tv=findViewById(R.id.textViewFSBTitle);

        Intent intent=getIntent();
        String cost=intent.getStringExtra("text3");
        String firmname=intent.getStringExtra("text1");
        String productname=intent.getStringExtra("text2");
        edPrice.setText("Rs : "+cost+"/-");
        tv.setText(productname);

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy", Locale.getDefault());
        String date = df.format(c);
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss");
        String time = mdformat.format(c.getTime());
        System.out.println(time);

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edname.getText().toString();
                String contact=edcontact.getText().toString();
                String address=edaddress.getText().toString();
                if(name.length()==0 || contact.length()==0 || address.length()==0)
                {
                    Toast.makeText(Fertilizeres_Seeds_buy_Activity.this, "Please fill all details", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs",MODE_PRIVATE);
                    String username=sharedPreferences.getString("username","").toString();

                    try (Database db = new Database(getApplicationContext(), "farmcare", null, 1)) {
                        db.addOrder(username,productname,firmname, edname.getText().toString(), edaddress.getText().toString(), edcontact.getText().toString(), edPrice.getText().toString(), date.toString(), time.toString(), "f/s");
                    }
                    Toast.makeText(Fertilizeres_Seeds_buy_Activity.this, "Your order is placed Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Fertilizeres_Seeds_buy_Activity.this,HomeActivity.class));
                }
            }
        });
    }
}