package com.terabytesoftware.dslist.services;

import com.terabytesoftware.dslist.dtos.GameDTO;
import com.terabytesoftware.dslist.dtos.GameMinDTO;
import com.terabytesoftware.dslist.entities.Game;
import com.terabytesoftware.dslist.projections.GameMinProjection;
import com.terabytesoftware.dslist.repositories.GameListRepository;
import com.terabytesoftware.dslist.repositories.GameRepository;
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