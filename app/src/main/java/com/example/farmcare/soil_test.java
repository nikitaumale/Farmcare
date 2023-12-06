package com.example.farmcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class soil_test extends AppCompatActivity {

    String [][] soil_test_details={};
    Button btn;
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil_test);
        btn = findViewById(R.id.buttonBack);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(soil_test.this,HomeActivity.class));
            }
        });
        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs",MODE_PRIVATE);
        String username=sharedPreferences.getString("username","").toString();

        Database db=new Database(getApplicationContext(),"farmcare",null,1);

        ArrayList dbData=db.getSoilTestDetails();
        soil_test_details=new String[dbData.size()][];

        for(int i=0;i<soil_test_details.length;i++)
        {
            soil_test_details[i]=new String[6];
            String arrData=dbData.get(i).toString();
            String[] strData=arrData.split(java.util.regex.Pattern.quote("$"));
            soil_test_details[i][0]=strData[0];
            soil_test_details[i][1]=strData[1];
            soil_test_details[i][2]=strData[2];
            soil_test_details[i][3]=strData[3];
            soil_test_details[i][4]=strData[4];
            soil_test_details[i][5]=strData[5];
        }

        list = new ArrayList();
        for(int i=0; i<soil_test_details.length; i++){
            item = new HashMap<String,String>();
            item.put("line1",soil_test_details[i][0]);
            item.put("line2",soil_test_details[i][1]);
            item.put("line3",soil_test_details[i][2]);
            item.put("line4","Pkg fees"+soil_test_details[i][3]+"/-");
            item.put("line5",soil_test_details[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewST);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it =new Intent(soil_test.this,soil_test_details.class);
                it.putExtra("text1",soil_test_details[i][0]);
                it.putExtra("text2",soil_test_details[i][2]);
                it.putExtra("text3",soil_test_details[i][3]);
                it.putExtra("text4",soil_test_details[i][5]);
                startActivity(it);

            }
        });
    }
}