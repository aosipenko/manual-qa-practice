package org.prog.demo.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Persons")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonTable {
    @Id
    @Column(name = "PersonID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "Title")
    private String title;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Nat")
    private String nat;
}
