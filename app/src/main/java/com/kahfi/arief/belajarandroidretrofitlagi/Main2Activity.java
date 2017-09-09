package com.kahfi.arief.belajarandroidretrofitlagi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.kahfi.arief.belajarandroidretrofitlagi.retrofithandler.RetrofitCreator;

import java.util.List;

public class Main2Activity extends AppCompatActivity {


    private ListView list;
    private Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        list = (ListView)findViewById(R.id.listView);
        back = (Button)findViewById(R.id.back);


        new RetrofitCreator(Main2Activity.this).selectCall(list);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
            }
        });

    }
}
