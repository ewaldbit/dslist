package com.superior.dslist.services;

import com.superior.dslist.dtos.GameDTO;
import com.superior.dslist.dtos.GameMinDTO;
import com.superior.dslist.entities.Game;
import com.superior.dslist.projections.GameMinProjection;
import com.superior.dslist.repositories.GameListRepository;
import com.superior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);

    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){

        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(GameMinDTO::new).collect(Collectors.toList());

    }
}
