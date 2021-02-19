package be.technifutur.demoSpringBoot.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString(exclude = "rules")
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    @Column
    @NotNull
    private int nbJoueurs;

    @OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE)
    private List<Rule> rules = new ArrayList<>();
}
