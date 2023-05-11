package com.bootcamp.dslist.services;

import com.bootcamp.dslist.dto.GameMinDTO;
import com.bootcamp.dslist.entities.Game;
import com.bootcamp.dslist.repositories.GameRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepostiory gameRepostiory;

    public List<GameMinDTO> findAll() {
       List<Game> result = gameRepostiory.findAll();
       return result.stream().map(GameMinDTO::new).toList();
    }
}
