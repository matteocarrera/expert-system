package org.grecha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "directions_id", nullable = false)
    private Direction direction;

    @NonNull
    private int price;

    @NonNull
    private int duration;

    @NonNull
    private String level;

    @NonNull
    private String courseLink;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "course_feature",
            joinColumns = @JoinColumn(name = "courses_id"),
            inverseJoinColumns = @JoinColumn(name = "features_id"))
    private List<Feature> features;
}
