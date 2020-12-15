package org.grecha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "technologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "areas_id")
    private Area area;

    @ManyToMany(mappedBy = "technologies", fetch = FetchType.EAGER)
    private List<Course> courses;

    @ManyToMany(mappedBy = "technologies", fetch = FetchType.EAGER)
    private List<Specialty> specialties;
}
