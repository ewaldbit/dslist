package com.terabytesoftware.dslist.services;

import com.terabytesoftware.dslist.dtos.GameListDTO;
import com.terabytesoftware.dslist.entities.GameList;
import com.terabytesoftware.dslist.projections.GameMinProjection;
import com.terabytesoftware.dslist.repositories.GameListRepository;
import com.terabytesoftware.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {

        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public void move(Long listID, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listID);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = (sourceIndex < destinationIndex) ? sourceIndex : destinationIndex;
        int max = (sourceIndex < destinationIndex) ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listID, list.get(i).getId(), i);
        }
    }
}