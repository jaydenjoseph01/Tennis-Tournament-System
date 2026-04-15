package com.tennistournament.controller;

import com.tennistournament.dto.requests.PlayerRequest;
import com.tennistournament.dto.responses.PlayerResponse;
import com.tennistournament.entity.Player;
import com.tennistournament.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<PlayerResponse> registerPlayer(@RequestBody PlayerRequest playerRequest) {
        Player newPlayer = playerService.registerPlayer(playerRequest);
        return new ResponseEntity<>(convertToResponse(newPlayer), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlayerResponse>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        List<PlayerResponse> playerResponses = players.stream()
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
