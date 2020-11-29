package projects.finalproject.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "developers")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@ToString @EqualsAndHashCode(of = "name")
public class Developer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "contact_person_name")
    private String contactPersonName;

    @Column(name = "contact_number")
    private String contactNumber;

}
