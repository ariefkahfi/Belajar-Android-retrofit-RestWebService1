package com.kahfi.arief.belajarandroidretrofitlagi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Arief on 9/9/2017.
 */

public class Person {


    private int id;
    private String nama;
    private String gender;


    public Person(){}

    public Person(String nama, String gender) {
        this.nama = nama;
        this.gender = gender;
    }

    public Person(int id, String nama, String gender) {
        this.id = id;
        this.nama = nama;
        this.gender = gender;
    }

    public void setId(int id){
        this.id=id;
    }
    public void setNama(String nama){
        this.nama=nama;
    }

    public int getId(){
        return id;
    }
    public String getNama(){
        return nama;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", gender=" + gender +
                '}';
    }
}
