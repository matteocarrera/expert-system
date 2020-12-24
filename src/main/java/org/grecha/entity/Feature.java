package org.grecha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "features")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @ManyToMany(mappedBy = "features", fetch = FetchType.EAGER)
    private List<Course> courses;
}
