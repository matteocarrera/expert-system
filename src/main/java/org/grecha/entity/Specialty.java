package org.grecha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "specialties")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;
    private String description;

    @ManyToMany(mappedBy = "specialties", fetch = FetchType.EAGER)
    private List<Course> courses;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "areas_id", nullable = false)
    private Area area;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "specialty_technology",
            joinColumns = @JoinColumn(name = "specialties_id"),
            inverseJoinColumns = @JoinColumn(name = "technologies_id"))
    private List<Technology> technologies;
}
