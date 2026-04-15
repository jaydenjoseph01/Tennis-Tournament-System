package com.tennistournament.service;

import com.tennistournament.dto.requests.MatchRequest;
import com.tennistournament.entity.Match;
import com.tennistournament.entity.Player;
import com.tennistournament.exception.ResourceNotFoundException;
import com.tennistournament.repository.MatchRepository;
import com.tennistournament.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository, PlayerRepository playerRepository) {
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
    }

    public Match recordMatch(MatchRequest matchRequest) {
        Player player1 = playerRepository.findById(Long.valueOf(matchRequest.getPlayer1Id()))
                .orElseThrow(() -> new ResourceNotFoundException("Player 1 not found"));

        Player player2 = playerRepository.findById(Long.valueOf(matchRequest.getPlayer2Id()))
                .orElseThrow(() -> new ResourceNotFoundException("Player 2 not found"));

        Player winner = playerRepository.findById(Long.valueOf(matchRequest.getWinnerId()))
                .orElseThrow(() -> new ResourceNotFoundException("Winner not found"));


        Match newMatch = new Match();
        newMatch.setPlayer1(player1);
        newMatch.setPlayer2(player2);
        newMatch.setWinner(winner);
        newMatch.setScore(matchRequest.getScore());
        newMatch.setMatchDate(matchRequest.getMatchDate());

        newMatch.setTournament(null);

        if(winner.equals(player1)) {
            player1.setWins(player1.getWins() + 1);
            player2.setLosses(player2.getLosses() + 1);
        } else {
            player2.setWins(player2.getWins() + 1);
            player1.setLosses(player1.getLosses() + 1);
        }

        playerRepository.save(player1);
        playerRepository.save(player2);

        return matchRepository.save(newMatch);
        }

        public List<Match> getMatchesByPlayer(Long playerId) {
            return matchRepository.findByPlayer1IdOrPlayer2Id(playerId, playerId);
        }

    }

