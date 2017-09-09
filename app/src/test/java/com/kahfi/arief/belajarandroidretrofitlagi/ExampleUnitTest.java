package com.kahfi.arief.belajarandroidretrofitlagi;

import android.util.Log;

import com.kahfi.arief.belajarandroidretrofitlagi.model.Person;
import com.kahfi.arief.belajarandroidretrofitlagi.retrofithandler.RetrofitAPI;
import com.kahfi.arief.belajarandroidretrofitlagi.retrofithandler.RetrofitCreator;

import org.junit.Test;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void testInsert()throws Exception{
        Person p = new Person("Ryan","Male");


        Retrofit retro = new Retrofit.Builder()
                .baseUrl("http://localhost:9090/android-rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retro.create(RetrofitAPI.class)
                .insertCallWebService(p)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                       if(response.isSuccessful()){
                           try {
                               Log.i("INFO",response.body().string());
                           } catch (IOException e) {
                               e.printStackTrace();
                           }
                       }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        t.printStackTrace();
                        Log.e("Error-Test-insert",t.getMessage());

                    }
                });

    }
}