package com.tennistournament.repository;

import com.tennistournament.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {


List<Match> findByTournamentId(Long tournamentId);


List<Match> findByPlayer1IdOrPlayer2Id(Long player1Id, Long player2Id);
}