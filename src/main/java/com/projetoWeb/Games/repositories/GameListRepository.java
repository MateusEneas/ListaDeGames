package com.projetoWeb.Games.repositories;

import com.projetoWeb.Games.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long > {

}
