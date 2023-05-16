package com.projetoWeb.Games.services;

import com.projetoWeb.Games.dto.GameListDTO;
import com.projetoWeb.Games.entities.GameList;
import com.projetoWeb.Games.projections.GameMinProjection;
import com.projetoWeb.Games.repositories.GameListRepository;
import com.projetoWeb.Games.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
       return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int posicaoOrigem, int posicaoDestino) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(posicaoOrigem);
        list.add(posicaoDestino, obj);
        int min = posicaoOrigem < posicaoDestino ? posicaoOrigem : posicaoDestino;
        int max = posicaoOrigem < posicaoDestino ? posicaoDestino : posicaoOrigem;

        for (int i = min; i<= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }

}
