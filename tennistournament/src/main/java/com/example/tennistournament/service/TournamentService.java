package com.example.tennistournament.service;

import com.example.tennistournament.dto.requests.TournamentRequest;
import com.example.tennistournament.entity.Tournament;
import com.example.tennistournament.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }
        public Tournament createTournament(TournamentRequest tournamentRequest) {
            Tournament newTournament = new Tournament();
            newTournament.setName(tournamentRequest.getName());
            newTournament.setLocation(tournamentRequest.getLocation());
            newTournament.setStartDate(tournamentRequest.getStartDate());
            newTournament.setEndDate(tournamentRequest.getEndDate());

            return tournamentRepository.save(newTournament);
        }
        public List<Tournament> getAllTournaments() {
            return tournamentRepository.findAll();
            }
    }

