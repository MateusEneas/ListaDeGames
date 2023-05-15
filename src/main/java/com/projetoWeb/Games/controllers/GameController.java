package com.projetoWeb.Games.controllers;

import com.projetoWeb.Games.dto.GameDTO;
import com.projetoWeb.Games.dto.GameMinDTO;
import com.projetoWeb.Games.entities.Game;
import com.projetoWeb.Games.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

}
