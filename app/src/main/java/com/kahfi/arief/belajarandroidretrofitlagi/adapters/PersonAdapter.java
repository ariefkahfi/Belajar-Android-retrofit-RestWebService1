package com.kahfi.arief.belajarandroidretrofitlagi.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kahfi.arief.belajarandroidretrofitlagi.R;
import com.kahfi.arief.belajarandroidretrofitlagi.model.Person;

import java.util.List;

/**
 * Created by Arief on 9/9/2017.
 */

public class PersonAdapter extends ArrayAdapter<Person> {

    private List<Person> data;



    public PersonAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Person> objects) {
        super(context, resource, objects);
        data =  objects;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        Person p = data.get(position);

       View v = ((Activity)getContext()).getLayoutInflater().inflate(R.layout.list_ui,parent,false);


        viewHolder holder = new viewHolder();


        holder.tId = (TextView)v.findViewById(R.id.tampilId);
        holder.tNama = (TextView)v.findViewById(R.id.tampilNama);
        holder.tGender = (TextView)v.findViewById(R.id.tampilGender);



        holder.tId.setText(String.valueOf(p.getId()));
        holder.tNama.setText(p.getNama());
        holder.tGender.setText(p.getGender());


        return v ;
    }

    private class viewHolder{
        private TextView tId,tNama,tGender;
    }
}
