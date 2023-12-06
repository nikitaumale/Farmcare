package com.example.farmcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Buy_test extends AppCompatActivity {

    EditText edname,edcontact,edaddress,edFees;
    Button dateButton,timeButton,btnBuy;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_test);

        edname=findViewById(R.id.editTextFullName);
        edcontact=findViewById(R.id.editTextContact);
        edaddress=findViewById(R.id.editTextAddress);
        edFees=findViewById(R.id.editTextFees);
        btnBuy=findViewById(R.id.buttonBuyTest);
        tv=findViewById(R.id.textViewBTTitle);
        dateButton=findViewById(R.id.buttonAppDate);
        timeButton=findViewById(R.id.buttonAppTime);

        //datepicker
        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        //timepicker
        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });

        Intent intent=getIntent();
        String cost=intent.getStringExtra("text3");
        String firmname=intent.getStringExtra("text1");
        String pkgname=intent.getStringExtra("text2");
        edFees.setText(cost);
        tv.setText(pkgname);

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edname.getText().toString();
                String contact=edcontact.getText().toString();
                String address=edaddress.getText().toString();
                if(name.length()==0 || contact.length()==0 || address.length()==0)
                {
                    Toast.makeText(Buy_test.this, "Please fill all details", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs",MODE_PRIVATE);
                    String username=sharedPreferences.getString("username","").toString();

                    try (Database db = new Database(getApplicationContext(), "farmcare", null, 1)) {
                        db.addOrder(username,pkgname,firmname, edname.getText().toString(), edaddress.getText().toString(), edcontact.getText().toString(), edFees.getText().toString(), dateButton.getText().toString(), timeButton.getText().toString(), "test");
                    }
                    Toast.makeText(Buy_test.this, "Your Booking is done Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Buy_test.this,HomeActivity.class));
                }
            }
        });

    }
    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                dateButton.setText(i2+"/"+i1+"/"+i);
            }
        };
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);

        int style= AlertDialog.THEME_HOLO_DARK;
        datePickerDialog=new DatePickerDialog(this,style,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }

    private void initTimePicker()
    {
        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener(){

            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timeButton.setText(i1+":"+i);
            }
        };
        Calendar cal=Calendar.getInstance();
        int hrs=cal.get(Calendar.HOUR);
        int mins=cal.get(Calendar.MINUTE);

        int style= AlertDialog.THEME_HOLO_DARK;
        timePickerDialog=new TimePickerDialog(this,style,timeSetListener,hrs,mins,true);
    }
}