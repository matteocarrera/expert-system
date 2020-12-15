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
    private String text;

    @NonNull
    private String level;

    @NonNull
    private int price;
    private Boolean internship;
    private int duration;
    private Boolean inspector;
    private Date start;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "course_technology",
            joinColumns = @JoinColumn(name = "courses_id"),
            inverseJoinColumns = @JoinColumn(name = "technologies_id"))
    private List<Technology> technologies;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "course_specialty",
            joinColumns = @JoinColumn(name = "courses_id"),
            inverseJoinColumns = @JoinColumn(name = "specialties_id"))
    private List<Specialty> specialties;
}
