package com.kahfi.arief.belajarandroidretrofitlagi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.kahfi.arief.belajarandroidretrofitlagi.model.Person;
import com.kahfi.arief.belajarandroidretrofitlagi.retrofithandler.RetrofitCreator;


public class MainActivity extends AppCompatActivity {


    private EditText editNama;

    private RadioGroup group;
    private RadioButton rbMale,rbFemale;


    private Button insert;


    private void refreshForms(){
        editNama.setText("");
        group.clearCheck();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        insert = (Button)findViewById(R.id.insert);

        editNama = (EditText)findViewById(R.id.editNama);

        group = (RadioGroup)findViewById(R.id.rGrup);
        rbMale = (RadioButton)findViewById(R.id.rMale);
        rbFemale = (RadioButton)findViewById(R.id.rFemale);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(editNama.getText().toString().trim().equals("")
                            || group.getCheckedRadioButtonId()==-1){
                        Toast.makeText(MainActivity.this, "form masih ada yang kosong", Toast.LENGTH_SHORT).show();
                    }else{
                        String nama = editNama.getText().toString().trim();
                        String g = null;

                        switch (group.getCheckedRadioButtonId()){
                            case R.id.rMale :
                                 g = rbMale.getText().toString().trim();
                                break;
                            case R.id.rFemale :
                                g = rbFemale.getText().toString().trim();
                                break;
                        }


                        Log.i("nama",nama);
                        Log.i("gender",g);

                        new RetrofitCreator(MainActivity.this)
                                .insertCall(
                                        new Person(nama,g)
                                );
                        refreshForms();
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                    Toast.makeText(MainActivity.this, "masih ada yang kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("list-person");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getTitle()=="list-person"){
            startActivity(new Intent(MainActivity.this,Main2Activity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
