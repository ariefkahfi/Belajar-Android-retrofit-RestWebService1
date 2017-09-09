package com.kahfi.arief.belajarandroidretrofitlagi.retrofithandler;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.kahfi.arief.belajarandroidretrofitlagi.R;
import com.kahfi.arief.belajarandroidretrofitlagi.adapters.PersonAdapter;
import com.kahfi.arief.belajarandroidretrofitlagi.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Arief on 9/9/2017.
 */

public class RetrofitCreator {

    private static final String BASE_URL = "http://192.168.1.100:9090/android-rest/";


    private Context context;

    public RetrofitCreator(Context context) {
        this.context = context;
    }

    public static Retrofit getInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void insertCall(Person p){
        Map<String,Object> map = new HashMap<>();

        map.put("nama",p.getNama());
        map.put("gender",p.getGender());

        getInstance().create(RetrofitAPI.class)
                .insertCallWebService(p)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            try {
                                Toast.makeText(context, response.body().string(), Toast.LENGTH_SHORT).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("ErrorInsertCall",t.getMessage());
                        t.printStackTrace();
                    }
                });
    }

    public void selectCall(final ListView list){
        getInstance().create(RetrofitAPI.class)
                .selectCallWebService()
                .enqueue(new Callback<JsonArray>() {
                    @Override
                    public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                        List<Person> data = new ArrayList<>();

                        for(JsonElement el : response.body()){
                           int id =  el.getAsJsonObject().get("id").getAsInt();
                           String nama = el.getAsJsonObject().get("nama").getAsString();
                           String gender = el.getAsJsonObject().get("gender").getAsString();


                           data.add(
                                   new Person(id,nama,gender)
                           );
                        }

                        list.setAdapter(new PersonAdapter(context, R.layout.list_ui,data));

                    }

                    @Override
                    public void onFailure(Call<JsonArray> call, Throwable t) {
                        Log.e("ErrorSelectCall",t.getMessage());
                        t.printStackTrace();
                    }
                });
    }


}
