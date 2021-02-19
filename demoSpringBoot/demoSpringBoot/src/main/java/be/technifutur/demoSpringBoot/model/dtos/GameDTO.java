package be.technifutur.demoSpringBoot.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameDTO {

    private int id;
    private String name;
    private int nbJoueurs;
    private List<RuleDTO> rules;
}
