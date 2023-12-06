package com.example.farmcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Dealers_list_Activity extends AppCompatActivity {

    TextView textView;
    String [][] Dealers_list={};
    Button btn;
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealers_list);

        btn = findViewById(R.id.buttonDLBack);
        textView=findViewById(R.id.textViewDLTitle);

        Intent intent=getIntent();
        textView.setText(intent.getStringExtra("title"));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dealers_list_Activity.this,Dealers_Activity.class));
            }
        });

        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs",MODE_PRIVATE);
        String username=sharedPreferences.getString("username","").toString();

        Database db=new Database(getApplicationContext(),"farmcare",null,1);

        ArrayList dbData;
        if(textView.getText().toString().equals("Vegetables Dealers"))
            dbData=db.getProductList("veg_dealers");
        else if(textView.getText().toString().equals("Pulses Dealers"))
            dbData=db.getProductList("pul_dealers");
        else if(textView.getText().toString().equals("Fruits Dealers"))
            dbData=db.getProductList("Fru_dealers");
        else
            dbData=db.getProductList("dealers");
        Dealers_list=new String[dbData.size()][];
        for(int i=0;i<Dealers_list.length;i++)
        {
            Dealers_list[i]=new String[5];
            String arrData=dbData.get(i).toString();
            String[] strData=arrData.split(java.util.regex.Pattern.quote("$"));
            Dealers_list[i][0]=strData[0];
            Dealers_list[i][1]=strData[1];
            Dealers_list[i][2]=strData[2];
            Dealers_list[i][3]=strData[3];
            Dealers_list[i][4]=strData[4];
        }

        list = new ArrayList();
        for(int i=0; i<Dealers_list.length; i++){
            item = new HashMap<String,String>();
            item.put("line1",Dealers_list[i][0]);
            item.put("line2",Dealers_list[i][1]);
            item.put("line3",Dealers_list[i][2]);
            item.put("line4","Time : "+Dealers_list[i][3]);
            item.put("line5",Dealers_list[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDL);
        lst.setAdapter(sa);
    }
}