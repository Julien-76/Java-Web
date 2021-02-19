package be.technifutur.demoSpringBoot.controller;

import be.technifutur.demoSpringBoot.model.entities.Game;
import be.technifutur.demoSpringBoot.model.entities.Rule;
import be.technifutur.demoSpringBoot.model.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/games")
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView getAllGames() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("game/getAll");
        mv.addObject("games", this.service.getAll());

        return mv;
    }

    @GetMapping("/one")
    public ModelAndView getOneGameById(@RequestParam("id") int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("game/getOne");
        mv.addObject("game", this.service.getById(id));

        return mv;
    }

    @GetMapping("/insert")
    public ModelAndView insert() {
        ModelAndView mv = new ModelAndView("game/insert");
        mv.addObject("game", new Game());
        return mv ;
    }

    @PostMapping("/insert")
    public ModelAndView insert(Game game, BindingResult result) {

        this.service.insert(game);

        return new ModelAndView("redirect:/games");
    }

    @GetMapping("/update")
    public ModelAndView update(@RequestParam("id") int id) {
        ModelAndView mv = new ModelAndView("game/update");
        mv.addObject("game", this.service.getById(id));
        mv.addObject("rule", new Rule());
        return mv ;
    }

    @PostMapping("/update")
    public ModelAndView update(Game game, @RequestParam("id") int id, BindingResult result) {

        this.service.update(game, id);

        return new ModelAndView("redirect:/games");
    }

    @GetMapping("/delete")
    public ModelAndView deleteById(@RequestParam("id") int id) {
        this.service.delete(id);
        return new ModelAndView("redirect:/games");
    }

}
