package com.kahfi.arief.belajarandroidretrofitlagi.retrofithandler;

import com.google.gson.JsonArray;
import com.kahfi.arief.belajarandroidretrofitlagi.model.Person;

import java.util.Map;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Arief on 9/9/2017.
 */

public interface RetrofitAPI {




    @POST("person")
    Call<ResponseBody> insertCallWebService(@Body Person person);

    @GET("person")
    Call<JsonArray> selectCallWebService();

}
