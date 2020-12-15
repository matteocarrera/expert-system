package org.grecha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "areas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;
    private String description;

    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Specialty> specialties;

    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Technology> technologies;
}
