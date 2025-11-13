package com.example.tennistournament.dto.requests;

public class PlayerRequest {

    private String name;
    private int age;
    private String country;
    private int wins;
    private int losses;

    //Getters and Setters Section
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }


    public void setLosses(int losses) {
        this.losses = losses;
     }
    }





