package be.technifutur.demoSpringBoot.model.services;

import be.technifutur.demoSpringBoot.mapper.Mapper;
import be.technifutur.demoSpringBoot.model.dtos.GameDTO;
import be.technifutur.demoSpringBoot.model.entities.Game;
import be.technifutur.demoSpringBoot.model.entities.QGame;
import be.technifutur.demoSpringBoot.model.repositories.GameRepository;
import be.technifutur.demoSpringBoot.model.repositories.RuleRepository;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GameService implements Crudable<Game, GameDTO, Integer> {

    private final GameRepository gameRepository;

    private final RuleRepository ruleRepository;

    private final Mapper mapper;

    public GameService(GameRepository repository, RuleRepository ruleRepository, Mapper mapper) {
        this.gameRepository = repository;
        this.ruleRepository = ruleRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GameDTO> getAll() {
        return this.gameRepository.findAll()
                .stream()
                .map(g -> mapper.toGameDto(g, true))
                .collect(Collectors.toList());
    }

    @Override
    public GameDTO getById(Integer integer) {

        Game game = this.gameRepository.findById(integer).orElseThrow(() -> new NoSuchElementException("Le jeu n'existe pas"));
        game.setRules(this.ruleRepository.findAllByGame(game));

        return mapper.toGameDto(game, true);

    }

    @Override
    public boolean insert(Game game) {
        Game newGame = this.gameRepository.save(game);
        return this.gameRepository.findById(newGame.getId()).isPresent();
    }

    @Override
    public boolean update(Game game, Integer integer) {
        Game old = this.gameRepository.getOne(integer);
        Game toTest = new Game(old.getId(), old.getName(), old.getNbJoueurs(), old.getRules());
        game.setId(integer);
        this.gameRepository.save(game);
        return !toTest.equals(this.gameRepository.getOne(integer));
    }

    @Override
    public boolean delete(Integer integer) {
        this.gameRepository.deleteById(integer);
        return this.gameRepository.findById(integer).isEmpty();
    }

    public boolean partialUpdate(Map<String, Object> updates, Integer integer) throws IllegalAccessException {
        Game gameToUpdate = this.mapper.toGameEntity(getById(integer));
        Class<?> clazz = Game.class;

        Field[] fields = clazz.getDeclaredFields();
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            Field field = Arrays.stream(fields)
                    .filter(f -> f.getName().equals(entry.getKey()))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException(("La propriété de la classe n'a pas été trouvée")));
            field.setAccessible(true);
            field.set(gameToUpdate, entry.getValue());
        }

        this.gameRepository.save(gameToUpdate);

        return true;
    }

    public List<GameDTO> search(Game game) {

        BooleanBuilder predicate = new BooleanBuilder();

        QGame qGame = QGame.game;

        if (game.getName()!= null && !game.getName().equals("")) {
            predicate.and(qGame.name.containsIgnoreCase(game.getName()));
        }

        if (game.getNbJoueurs() != 0) {
            predicate.and(qGame.nbJoueurs.eq(game.getNbJoueurs()));
        }

        Iterable<Game> result = this.gameRepository.findAll(predicate);

        return StreamSupport.stream(result.spliterator(), false)
                .map(mapper::toGameDto)
                .collect(Collectors.toList());

    }
}
