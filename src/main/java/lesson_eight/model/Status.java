package lesson_eight.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "statuses")
@Data
@NoArgsConstructor
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(unique = true)
    private String alias;
    private String description;
}
