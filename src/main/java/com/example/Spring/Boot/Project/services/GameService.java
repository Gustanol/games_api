package com.example.Spring.Boot.Project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Spring.Boot.Project.dto.GameDTO;
import com.example.Spring.Boot.Project.dto.GameMinDTO;
import com.example.Spring.Boot.Project.entities.Game;
import com.example.Spring.Boot.Project.repositories.GameRepository;

@Service
public class GameService {
  
  @Autowired
  private GameRepository gameRepository;
  
  @Transactional(readOnly = true)
  public GameDTO findById(Long gameId) {
    Game result = gameRepository.findById(gameId).get();
    return new GameDTO(result);
  }
  
  @Transactional(readOnly = true)
  public List<GameMinDTO> findAll() {
    List<Game> result = gameRepository.findAll();
    return result.stream().map(x -> new GameMinDTO(x)).toList();
  }
}