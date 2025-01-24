# This is my first project using Spring Boot framework 🥳

PS: The content of this repository is based on
[DevSuperior's](https://github.com/devsuperior) "Intensivão - Java Spring"!
💻

---

## How does it work? 🤔

### - [After first lesson (2025-01-20)](https://github.com/Gustanol/games_api/tree/v1.0)

- The Game entity
[(`entities/Game.java`)](./src/main/java/com/example/Spring/Boot/Project/entities/Game.java)
create a simple
temporary **H2 database table**, called "tb_game", using **ORM**
(Object-Relational Mapping). 

```java
@Entity
@Table(name = "tb_game")
public class Game {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	
private String title;
	
@Column(name = "game_year")
private Integer year;
private String genre;
private String platforms;
private Double score;
private String imgUrl;
  
@Column(columnDefinition = "TEXT")
private String shortDescription;
  
@Column(columnDefinition = "TEXT")
private String longDescription; 
```

  - The file [`import.sql`](./src/main/resources/import.sql) is used to insert content into this table.
- The [`repositories/GameRepository.java`](./src/main/java/com/example/Spring/Boot/Project/repositories/GameRepository.java)
uses the **JpaRepository** interface to manipulate data from database
(`Game.java`).

  ```java
  JpaRepository<Game, Long>
  ```
- This project uses **DTO (Data Transfer Object)**, that "filter" content from
entity, hiding, for example, sensitive data. It happens at
[`GameMinDTO.java`](./src/main/java/com/example/Spring/Boot/Project/dto/GameMinDTO.java).

```java
private Long id;
private String title;
private Integer year;
private String imgUrl;
private String shortDescription; 
```

- The main service
[(`services/GameService.java`)](./src/main/java/com/example/Spring/Boot/Project/services/GameService.java)
uses the `findAll()` method, from **JpaRepository**, to return all entities from the main entity.
After this, it uses the response as parameter for a new **DTO** object, and
return that as a list.

```java
List<Game> result = gameRepository.findAll(); // catch all entities
return result.stream().map(x -> new GameMinDTO(x)).toList();
```

- The main controller
[(`controllers/GameController.java`)](./src/main/java/com/example/Spring/Boot/Project/controllers/GameController.java)
return all entities from the list returned from `GameService.java` using
`findAll()` method and map it into a route called `/games`.

```java
@RestController
@RequestMapping(value = "/games") // route
public class GameController {
   
  @Autowired
  private GameService gameService;
   
  @GetMapping
 	public List<GameMinDTO> findAll() {
  	List<GameMinDTO> result = gameService.findAll(); // return all DTO entities
  	return result;
  }
}
```

---

## How to run it? 🤖

- Firstly, clone this repository:

```bash
git clone https://github.com/Gustanol/games_api.git && cd games_api
```

- Secondly, make sure you have **Maven** installed. If you haven't yet, follow the instructions in this [page](https://maven.apache.org/download.cgi).

- Thirdly, execute the command:

```bash
mvn clean install
```

- After this, you can run the app by running:

```bash
mvn spring-boot:run
```

- Now, access [http://localhost:8080/games](http://localhost:8080/games) and see
the API! 🤓

---

PS: If you prefer, you can run it into an IDE as well!

---