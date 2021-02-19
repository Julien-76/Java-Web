package be.technifutur.demoSpringBoot.controller;

import be.technifutur.demoSpringBoot.model.entities.Game;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller()
@RequestMapping(path = "/test")
public class DemoController {

    List<Game> games = Arrays.asList(
            new Game(1,"Stratego", 2, null),
            new Game(2, "Monopoly", 4, null),
            new Game(3, "Puissance 4", 2, null)
    );

    @RequestMapping(path = "/coucou", method = RequestMethod.GET)
    public ModelAndView sayHello() {
        ModelAndView mv = new ModelAndView("coucou");
        mv.addObject("games", games);
        return mv;
    }
}
