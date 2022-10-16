package com.demo.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name="characters")
public class Character implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCharacter")
    private Long id;
    private String image;
    private String name;
    private int age;
    private double weight;
    private String history;

    @JsonIgnoreProperties("characters")
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "characters")
    private Set<Movie> movies = new HashSet<>();


    public Character() {
    }

    public Character(Long id, String image, String name, int age, double weight, String history, Set<Movie> movies) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.movies = movies;
    }
}
