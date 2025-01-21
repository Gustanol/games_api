package com.example.Spring.Boot.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring.Boot.Project.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
  
}