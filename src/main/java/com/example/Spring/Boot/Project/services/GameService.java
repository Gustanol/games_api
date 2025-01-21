package com.example.Spring.Boot.Project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Spring.Boot.Project.dto.GameMinDTO;
import com.example.Spring.Boot.Project.entities.Game;
import com.example.Spring.Boot.Project.repositories.GameRepository;

@Component
public class GameService {
  
  @Autowired
  private GameRepository gameRepository;
  
  public List<GameMinDTO> findAll() {
    List<Game> result = gameRepository.findAll();
    return result.stream().map(x -> new GameMinDTO(x)).toList();
  }
}