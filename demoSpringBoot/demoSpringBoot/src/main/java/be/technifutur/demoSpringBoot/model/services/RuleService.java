package be.technifutur.demoSpringBoot.model.services;

import be.technifutur.demoSpringBoot.mapper.Mapper;
import be.technifutur.demoSpringBoot.model.dtos.RuleDTO;
import be.technifutur.demoSpringBoot.model.entities.Game;
import be.technifutur.demoSpringBoot.model.entities.Rule;
import be.technifutur.demoSpringBoot.model.repositories.RuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RuleService implements Crudable<Rule, RuleDTO, Integer> {

    private final RuleRepository repository;

    private final Mapper mapper;

    public RuleService(RuleRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<RuleDTO> getAll() {
        return this.repository.findAll()
                .stream()
                .map(mapper::toRuleDTO)
                .collect(Collectors.toList()
                );
    }

    @Override
    public RuleDTO getById(Integer integer) {
        return null;
    }

    @Override
    public boolean insert(Rule rule) {
        Rule newRule = this.repository.save(rule);
        return this.repository.findById(newRule.getId()).isPresent();

    }

    @Override
    public boolean update(Rule rule, Integer integer) {
        Rule old = this.repository.getOne(integer);
        rule.setId(integer);
        this.repository.save(rule);
        return !old.equals(this.repository.getOne(integer));
    }

    @Override
    public boolean delete(Integer integer) {

        this.repository.deleteById(integer);

        return this.repository.findById(integer).isEmpty();
    }
}
