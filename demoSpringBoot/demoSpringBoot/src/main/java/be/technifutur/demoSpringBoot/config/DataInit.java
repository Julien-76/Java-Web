package be.technifutur.demoSpringBoot.config;

import be.technifutur.demoSpringBoot.model.entities.Game;
import be.technifutur.demoSpringBoot.model.entities.Rule;
import be.technifutur.demoSpringBoot.model.services.GameService;
import be.technifutur.demoSpringBoot.model.services.RuleService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataInit implements InitializingBean {

    private final GameService gameService;

    private final RuleService ruleService;

    private List<Game> games = Arrays.asList(
            Game.builder()
                    .name("Stratego")
                    .nbJoueurs(2)
                    .build(),
            Game.builder()
                    .name("Puissance 4")
                    .nbJoueurs(2)
                    .build(),
            Game.builder()
                    .name("Monopoly")
                    .nbJoueurs(4)
                    .build()
    );

    private List<Rule> rules = Arrays.asList(
            Rule.builder()
                    .name("Rule 1")
                    .description("la règle 1")
                    .game(games.get(0))
                    .build(),
            Rule.builder()
                    .name("Rule 2")
                    .description("la règle 2")
                    .game(games.get(0))
                    .build(),
            Rule.builder()
                    .name("Rule 3")
                    .description("la règle 3")
                    .game(games.get(1))
                    .build(),
            Rule.builder()
                    .name("Rule 4")
                    .description("la règle 4")
                    .game(games.get(1))
                    .build(),
            Rule.builder()
                    .name("Rule 5")
                    .description("la règle 5")
                    .game(games.get(2))
                    .build()
    );

    public DataInit(GameService gameService, RuleService ruleService) {
        this.gameService = gameService;
        this.ruleService = ruleService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.games.forEach(gameService::insert);
        this.rules.forEach(ruleService::insert);
    }
}
