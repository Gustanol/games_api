package com.example.Spring.Boot.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring.Boot.Project.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
  
}