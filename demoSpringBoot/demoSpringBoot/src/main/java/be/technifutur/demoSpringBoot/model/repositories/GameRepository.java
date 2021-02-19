package be.technifutur.demoSpringBoot.model.repositories;

import be.technifutur.demoSpringBoot.model.entities.Game;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface GameRepository extends JpaRepository<Game, Integer> , QuerydslPredicateExecutor<Game> {


}
