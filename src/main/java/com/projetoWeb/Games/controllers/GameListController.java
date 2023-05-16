package com.projetoWeb.Games.controllers;

import com.projetoWeb.Games.dto.GameListDTO;
import com.projetoWeb.Games.dto.GameMinDTO;
import com.projetoWeb.Games.dto.ReplacementDTO;
import com.projetoWeb.Games.services.GameListService;
import com.projetoWeb.Games.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getPosicaoOrigem(), body.getPosicaoDestino());
    }

}
