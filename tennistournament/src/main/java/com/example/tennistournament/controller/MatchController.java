package com.example.tennistournament.controller;

import com.example.tennistournament.dto.requests.MatchRequest;
import com.example.tennistournament.dto.responses.MatchResponse;
import com.example.tennistournament.dto.responses.PlayerResponse;
import com.example.tennistournament.entity.Match;
import com.example.tennistournament.entity.Player;
import com.example.tennistournament.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matches")
public class MatchController {

    final MatchService matchService;


    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }
    
    public ResponseEntity<MatchResponse> recordMatch(@RequestBody MatchRequest matchRequest) {
        Match newMatch = matchService.recordMatch(matchRequest);

        MatchResponse responseBody = convertToResponse(newMatch);

        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }

    private MatchResponse convertToResponse(Match newMatch) {
        MatchResponse response = new MatchResponse();
        
        response.setId(newMatch.getId());
        response.setTournamentId(newMatch.getTournament().getId());
        response.setMatchDate(newMatch.getMatchDate());
        response.setScore(newMatch.getScore());

        response.setPlayer1(convertToPlayerResponse(newMatch.getPlayer1()));
        response.setPlayer2(convertToPlayerResponse(newMatch.getPlayer2()));
        response.setWinner(convertToPlayerResponse(newMatch.getWinner()));;
        return response;
    }

    private PlayerResponse convertToPlayerResponse(Player player) {
        if (player == null) {
            return null;
        }

        PlayerResponse response = new PlayerResponse();
        response.setId(player.getId());
        response.setName(player.getName());
        response.setAge(player.getAge());
        response.setCountry(player.getCountry());
        response.setWins(player.getWins());
        response.setLosses(player.getLosses());

        return response;


    }
}
