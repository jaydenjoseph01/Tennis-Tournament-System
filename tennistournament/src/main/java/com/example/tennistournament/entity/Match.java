package com.example.tennistournament.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
public class Match {
    @ManyToMany
    @JoinColumn(name = "player1_id")
    private Player player1;




    //getters and setters
}
