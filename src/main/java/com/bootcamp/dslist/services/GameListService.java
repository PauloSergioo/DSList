package com.bootcamp.dslist.services;

import com.bootcamp.dslist.dto.GameListDTO;
import com.bootcamp.dslist.entities.GameList;
import com.bootcamp.dslist.projections.GameMinProjection;
import com.bootcamp.dslist.repositories.GameListRepostiory;
import com.bootcamp.dslist.repositories.GameRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepostiory gameListRepostiory;

    @Autowired
    private GameRepostiory gameRepostiory;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
       List<GameList> result = gameListRepostiory.findAll();
       return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepostiory.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepostiory.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }


}
