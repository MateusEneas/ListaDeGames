package com.projetoWeb.Games.repositories;

import com.projetoWeb.Games.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long > {

}
