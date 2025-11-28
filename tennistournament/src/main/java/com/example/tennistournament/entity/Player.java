package com.example.tennistournament.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

   private Long id;
   private String name;
   private String country;
   private int age;
   private int wins;
   private int losses;

   @ManyToMany(mappedBy = "players")
    private Set<Tournament> tournaments = new HashSet<>();

   public Player() {
   }

    //getters and setters
    public Long getId() {
       return id;
    }

    public void setId(int id) {
       this.id = (long) id;
    }

    public String getName() {
       return name;
    }

    public void setName(String name) {
       this.name = name;
    }

    public String getCountry() {
       return country;
    }

    public void setCountry(String country) {
       this.country = country;
    }

    public int getAge() {
       return age;
    }

    public void setAge(int age) {
       this.age = age;
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

    public Set<Tournament> getTournaments() {
       return tournaments;
    }

    public void setTournaments(Set<Tournament> tournaments) {
       this.tournaments = tournaments;
    }
}
