package lesson_seven.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cources")
@Data
@NoArgsConstructor

public class Cource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;

    @ManyToMany(mappedBy = "cources")
    private Set<Client> clients;

}
