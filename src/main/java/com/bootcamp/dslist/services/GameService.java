package com.bootcamp.dslist.services;

import com.bootcamp.dslist.dto.GameDTO;
import com.bootcamp.dslist.dto.GameMinDTO;
import com.bootcamp.dslist.entities.Game;
import com.bootcamp.dslist.repositories.GameRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepostiory gameRepostiory;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepostiory.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
       List<Game> result = gameRepostiory.findAll();
       return result.stream().map(GameMinDTO::new).toList();
    }

}
