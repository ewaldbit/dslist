package com.superior.dslist.services;

import com.superior.dslist.dtos.GameMinDTO;
import com.superior.dslist.entities.Game;
import com.superior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    public List<GameMinDTO> findAll(){

        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).collect(Collectors.toList());

    }
}
