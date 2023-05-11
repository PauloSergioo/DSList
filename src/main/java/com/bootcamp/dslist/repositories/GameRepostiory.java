package com.bootcamp.dslist.repositories;

import com.bootcamp.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepostiory extends JpaRepository<Game, Long> {

}
