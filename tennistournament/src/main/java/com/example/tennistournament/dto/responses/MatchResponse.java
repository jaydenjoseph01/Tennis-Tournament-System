package com.example.tennistournament.dto.responses;

import java.time.LocalDate;

public class MatchResponse {

    private int id;
    private LocalDate matchDate;
    private String score;
    private String tournamentName;
    private PlayerResponse player1;
    private PlayerResponse player2;
    private PlayerResponse winner;

    //Getters and Setters section

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public PlayerResponse getPlayer1() {
        return player1;
    }

    public void setPlayer1(PlayerResponse player1) {
        this.player1 = player1;
    }

    public PlayerResponse getPlayer2() {
        return player2;
    }

    public void setPlayer2(PlayerResponse player2) {
        this.player2 = player2;
    }

    public PlayerResponse getWinner() {
        return winner;
    }

    public void setWinner(PlayerResponse winner) {
        this.winner = winner;
    }

    public void setTournamentId(Long id) {
    }
}
