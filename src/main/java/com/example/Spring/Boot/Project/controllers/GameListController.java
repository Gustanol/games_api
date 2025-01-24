 package com.example.Spring.Boot.Project.controllers;
 
 import java.util.List;
 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 import org.springframework.web.bind.annotation.PathVariable;
 
 import com.example.Spring.Boot.Project.dto.GameListDTO;
 import com.example.Spring.Boot.Project.dto.GameMinDTO;
 import com.example.Spring.Boot.Project.services.GameListService;
 import com.example.Spring.Boot.Project.services.GameService;
 
 @RestController
 @RequestMapping(value = "/lists")
 public class GameListController {
   
   @Autowired
   private GameListService gameListService;
   
   @Autowired
   private GameService gameService;
  	
   @GetMapping
   public List<GameListDTO> findAll() {
  		List<GameListDTO> result = gameListService.findAll();
  		return result;
  	}
  	
  	@GetMapping(value = "/{listId}/games")
  	public List<GameMinDTO> findByList(@PathVariable Long listId) {
  		List<GameMinDTO> result = gameService.findByList(listId);
  		return result;
  	}
 }
 