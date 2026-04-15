package com.tennistournament.controller;

import com.tennistournament.dto.requests.TournamentRequest;
import com.tennistournament.dto.responses.TournamentResponse;
import com.tennistournament.entity.Tournament;
import com.tennistournament.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping
    public ResponseEntity<TournamentResponse> createTournament(@RequestBody TournamentRequest tournamentRequest) {
        Tournament newTournament = tournamentService.createTournament(tournamentRequest);
        return new ResponseEntity<>(convertToResponse(newTournament), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TournamentResponse>> getAllTournaments() {
     List<Tournament> tournaments = tournamentService.getAllTournaments();

     List<TournamentResponse> tournamentResponses = tournaments.stream()
             .map(this::convertToResponse)
             .collect(Collectors.toList());
     return new ResponseEntity<>(tournamentResponses, HttpStatus.OK);
    }

    private TournamentResponse convertToResponse(Tournament newTournament) {
        TournamentResponse response = new TournamentResponse();
        response.setId(Math.toIntExact(newTournament.getId()));
        response.setName(newTournament.getName());
        response.setLocation(newTournament.getLocation());
        response.setStartDate(newTournament.getStartDate());
        response.setEndDate(newTournament.getEndDate());


        return response;
    }
}
