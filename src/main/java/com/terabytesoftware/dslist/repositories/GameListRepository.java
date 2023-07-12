package com.terabytesoftware.dslist.repositories;

import com.terabytesoftware.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
