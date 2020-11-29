package projects.finalproject.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "developers")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@ToString @EqualsAndHashCode(of = "developerName")
public class Developer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "developer_name")
    private String developerName;

    @Column(name = "contact_person_name")
    private String contactPersonName;

    @Column(name = "contact_number")
    private String contactNumber;

}
