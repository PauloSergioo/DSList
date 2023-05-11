package com.bootcamp.dslist.repositories;

import com.bootcamp.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepostiory extends JpaRepository<GameList, Long> {

}
