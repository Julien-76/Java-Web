package be.technifutur.demoSpringBoot.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RuleDTO {

    private int id;

    private String name;

    private String description;

    private GameDTO game;
}
