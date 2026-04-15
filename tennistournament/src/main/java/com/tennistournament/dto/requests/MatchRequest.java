package com.tennistournament.dto.requests;

import java.time.LocalDate;

public class MatchRequest {
    private int player1Id;
    private int player2Id;
    private int winnerId;
    private int tournamentId;
    private LocalDate matchDate;
    private String score;

    //Getters and Setters section
    public int getPlayer1Id() {
        return player1Id;
    }

    public void setPlayerId(int player1Id) {
        this.player1Id = player1Id;
    }

    public int getPlayer2Id(){
        return player2Id;
    }

    public void setPlayer2Id(int player2Id) {
        this.player2Id = player2Id;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
      }
    }
