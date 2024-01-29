package gemstar;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.UUID;

@Getter
@Setter
@Builder
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "person")
@Table(name = "person", schema = "gemstar")
public class Person extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 50)
    public String firstName;

    @Column(length = 50)
    public String lastName;

    @Column(length = 100, unique = true)
    public String email;

    public int age;
}
