package be.technifutur.demoSpringBoot.model.repositories;

import be.technifutur.demoSpringBoot.model.entities.Game;
import be.technifutur.demoSpringBoot.model.entities.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface RuleRepository extends JpaRepository<Rule, Integer> {
    List<Rule> findAllByGame(Game game);
}
