package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
public class Match {
    @ManyToMany
    @JoinColumn
    private Player player1;
}
