package be.technifutur.demoSpringBoot.api.controller;

import be.technifutur.demoSpringBoot.model.dtos.GameDTO;
import be.technifutur.demoSpringBoot.model.entities.Game;
import be.technifutur.demoSpringBoot.model.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RequestMapping(path = "/api/games")
@RestController
public class GameApiController implements RestControllable<Game, GameDTO, Integer> {

    private final GameService gameservice;

    public GameApiController(GameService gameservice) {
        this.gameservice = gameservice;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<GameDTO>> getAll() {
        return ResponseEntity.ok(this.gameservice.getAll());

    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<GameDTO> geetOne(@PathVariable("id") Integer integer) {
        return ResponseEntity.ok(this.gameservice.getById(integer));
    }

    @Override
    @PostMapping
    public ResponseEntity<Boolean> insert(@RequestBody Game game) {
        return ResponseEntity.ok(this.gameservice.insert(game));
    }

    @Override
    @PutMapping(path = "{/id}")
    public ResponseEntity<Boolean> update(@RequestBody  Game game, @PathVariable("id") Integer integer) {
        return ResponseEntity.ok(this.gameservice.update(game, integer));
    }

    @Override
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer integer) {
        return ResponseEntity.ok(this.gameservice.delete(integer));
    }
    @PatchMapping(path = "/{id}")
    public ResponseEntity<Boolean> partialUpdate(@RequestBody Map<String, Object> updates, @PathVariable Integer id) throws IllegalAccessException {
        return ResponseEntity.ok(this.gameservice.partialUpdate(updates, id));
    }

    @PostMapping(path = "/search")
    public ResponseEntity<List<GameDTO>> search(@RequestBody Game game) {
        return ResponseEntity.ok(this.gameservice.search(game));
    }
}
