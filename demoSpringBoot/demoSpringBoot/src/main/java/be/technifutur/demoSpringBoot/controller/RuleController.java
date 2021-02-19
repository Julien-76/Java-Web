package be.technifutur.demoSpringBoot.controller;

import be.technifutur.demoSpringBoot.model.dtos.RuleDTO;
import be.technifutur.demoSpringBoot.model.entities.Rule;
import be.technifutur.demoSpringBoot.model.repositories.GameRepository;
import be.technifutur.demoSpringBoot.model.repositories.RuleRepository;
import be.technifutur.demoSpringBoot.model.services.RuleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping(path = "/rules")
public class RuleController {

    private final RuleService service;

    private final GameRepository gameRepository;

    private final RuleRepository ruleRepository;

    public RuleController(RuleService service, GameRepository gameRepository, RuleRepository ruleRepository) {
        this.service = service;
        this.gameRepository = gameRepository;
        this.ruleRepository = ruleRepository;
    }

    @GetMapping
    public List<RuleDTO> getAllRules() {
        return this.service.getAll();
    }

    @PostMapping("/insert")
    public ModelAndView insert(Rule rule, @RequestParam("id") int id) {
        rule.setId(0);
        rule.setGame(this.gameRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Jeu non trouvé")));
        this.service.insert(rule);
        return new ModelAndView("redirect:/games/update/?id=" + id);
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("id") int id, @RequestParam("gameId") int gameId) {
        this.service.delete(id);
        return new ModelAndView("redirect:/games/one/?id=" + gameId);
    }

    @GetMapping("/update")
    public ModelAndView update(@RequestParam("id") int id) {
        ModelAndView mv = new ModelAndView("rule/update");
        mv.addObject("rule", this.ruleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Règle non trouvée")));
        return mv ;
    }

    @PostMapping("/update")
    public ModelAndView update(Rule rule, @RequestParam("id") int id, @RequestParam("gameId") int gameId) {
        rule.setGame(this.gameRepository.findById(gameId).orElseThrow(() -> new NoSuchElementException("Jeu non trouvé")));
        this.service.update(rule, id);

        return new ModelAndView("redirect:/games/one/?id=" + gameId);
    }

}
