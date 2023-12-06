package com.example.farmcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Farm_Articles_Activity extends AppCompatActivity {

    String [][] Articles_list={};
    Button btn;
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_articles);
        btn = findViewById(R.id.buttonBack);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Farm_Articles_Activity.this,HomeActivity.class));
            }
        });

        Database db=new Database(getApplicationContext(),"farmcare",null,1);
        ArrayList dbData=db.getArticlesList();

        Articles_list=new String[dbData.size()][];
        for(int i=0;i<Articles_list.length;i++)
        {
            Articles_list[i]=new String[5];
            String arrData=dbData.get(i).toString();
            String[] strData=arrData.split(java.util.regex.Pattern.quote("$"));
            Articles_list[i][0]=strData[0];
            Articles_list[i][1]=strData[1];
        }

        list = new ArrayList();
        for(int i=0; i<Articles_list.length; i++){
            item = new HashMap<String,String>();
            item.put("line1",Articles_list[i][0]);
            item.put("line2",Articles_list[i][1]);
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1"},
                new int[]{R.id.line_a}
        );
        ListView lst = findViewById(R.id.listViewA);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it =new Intent(Farm_Articles_Activity.this,Farm_Articles_Details_Activity.class);
                it.putExtra("text1",Articles_list[i][0]);
                it.putExtra("text2",Articles_list[i][1]);
                startActivity(it);
            }
        });
    }
}