package com.tennistournament.controller;

import com.tennistournament.dto.responses.PlayerResponse;
import com.tennistournament.entity.Player;
import com.tennistournament.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;
import java.util.List;

@RestController
@RequestMapping("/rankings")
public class RankingController {

    private final PlayerService playerService;
    @Autowired
    public RankingController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<PlayerResponse>> getPlayerRankings() {
        List<Player> rankedPlayers = playerService.getPlayerRankings();

        List<PlayerResponse> playerResponses = rankedPlayers.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());

        return new ResponseEntity<>(playerResponses, HttpStatus.OK);
    }

    private PlayerResponse convertToResponse(Player player) {
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


//rank players by their scores