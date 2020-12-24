package org.grecha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "directions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "direction", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Course> courses;
}
