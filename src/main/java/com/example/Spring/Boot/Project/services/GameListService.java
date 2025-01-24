package com.example.Spring.Boot.Project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Spring.Boot.Project.dto.GameDTO;
import com.example.Spring.Boot.Project.dto.GameListDTO;
import com.example.Spring.Boot.Project.entities.GameList;
import com.example.Spring.Boot.Project.repositories.GameListRepository;

@Service
public class GameListService {
  
  @Autowired
  private GameListRepository gameListRepository;
  
  @Transactional(readOnly = true)
  public List<GameListDTO> findAll() {
    List<GameList> result = gameListRepository.findAll();
    return result.stream().map(x -> new GameListDTO(x)).toList();
  }
}