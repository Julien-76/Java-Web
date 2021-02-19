package be.technifutur.demoSpringBoot.mapper;

import be.technifutur.demoSpringBoot.model.dtos.GameDTO;
import be.technifutur.demoSpringBoot.model.dtos.RuleDTO;
import be.technifutur.demoSpringBoot.model.entities.Game;
import be.technifutur.demoSpringBoot.model.entities.Rule;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class Mapper {

    public GameDTO toGameDto(Game game) {
        return toGameDto(game, false);
    }

    public GameDTO toGameDto(Game game, boolean withRules) {
        return GameDTO.builder()
                .id(game.getId())
                .name(game.getName())
                .nbJoueurs(game.getNbJoueurs())
                .rules(withRules ? game.getRules()
                        .stream()
                        .map(this::toRuleDTO)
                        .collect(Collectors.toList())
                        : null
                )
                .build();
    }

    public Game toGameEntity(GameDTO game) {
        return Game.builder()
                .id(game.getId())
                .name(game.getName())
                .nbJoueurs(game.getNbJoueurs())
//                .rules(game.getRules()
//                        .stream()
//                        .map(this::toRuleEntity)
//                        .collect(Collectors.toList())
//                )
                .build();
    }

    public RuleDTO toRuleDTO(Rule rule) {
        return RuleDTO.builder()
                .id(rule.getId())
                .name(rule.getName())
                .description(rule.getDescription())
                .game(toGameDto(rule.getGame()))
                .build();
    }

    public Rule toRuleEntity(RuleDTO dto) {
        return Rule.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .game(toGameEntity(dto.getGame()))
                .build();
    }

}
