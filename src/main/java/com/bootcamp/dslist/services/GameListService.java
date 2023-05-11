package com.bootcamp.dslist.services;

import com.bootcamp.dslist.dto.GameDTO;
import com.bootcamp.dslist.dto.GameListDTO;
import com.bootcamp.dslist.dto.GameMinDTO;
import com.bootcamp.dslist.entities.Game;
import com.bootcamp.dslist.entities.GameList;
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

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
       List<GameList> result = gameListRepostiory.findAll();
       return result.stream().map(GameListDTO::new).toList();
    }

}
