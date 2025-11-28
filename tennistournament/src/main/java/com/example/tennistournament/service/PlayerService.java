package com.example.tennistournament.service;

import com.example.tennistournament.dto.requests.PlayerRequest;
import com.example.tennistournament.entity.Player;
import com.example.tennistournament.exception.ResourceNotFoundException;
import com.example.tennistournament.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player registerPlayer(PlayerRequest playerRequest) {
        Player newPlayer = new Player();
        newPlayer.setName(playerRequest.getName());
        newPlayer.setAge(playerRequest.getAge());
        newPlayer.setCountry(playerRequest.getCountry());

        newPlayer.setWins(0);
        newPlayer.setLosses(0);

        return playerRepository.save(newPlayer);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Player not found with id: " + id));

    }

    public Player updatePlayerStats(Long id, PlayerRequest playerRequest) {
        Player existingPlayer = getPlayerById(id);
        existingPlayer.setWins(playerRequest.getWins());
        existingPlayer.setLosses(playerRequest.getLosses());
        return playerRepository.save(existingPlayer);
    }

    public void removePlayer(Long id) {
        Player existingPlayer = getPlayerById(id);
        playerRepository.delete(existingPlayer);
    }
    public List<Player> getPlayerRankings() {
        return playerRepository.findAllByOrderByWinsDesc();
    }
}
