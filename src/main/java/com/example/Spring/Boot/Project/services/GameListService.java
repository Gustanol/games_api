package com.example.Spring.Boot.Project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Spring.Boot.Project.dto.GameDTO;
import com.example.Spring.Boot.Project.dto.GameListDTO;
import com.example.Spring.Boot.Project.entities.GameList;
import com.example.Spring.Boot.Project.projections.GameMinProjection;
import com.example.Spring.Boot.Project.repositories.GameListRepository;
import com.example.Spring.Boot.Project.repositories.GameRepository;

@Service
public class GameListService {
  
  @Autowired
  private GameListRepository gameListRepository;
  
  @Autowired
  private GameRepository gameRepository;
  
  @Transactional(readOnly = true)
  public List<GameListDTO> findAll() {
    List<GameList> result = gameListRepository.findAll();
    return result.stream().map(x -> new GameListDTO(x)).toList();
  }
  
  @Transactional
  public void move(Long listId, int sourceIndex, int destinationIndex) {
    List<GameMinProjection> list = gameRepository.searchByList(listId);
    GameMinProjection obj = list.remove(sourceIndex);
    list.add(destinationIndex, obj);
    
    int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
    int max = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;
    
    for(int i = min; i <= max; i++) {
      gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
    }
  }
}