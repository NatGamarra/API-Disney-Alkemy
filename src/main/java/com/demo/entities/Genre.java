package com.demo.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name="genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idGenre")
    private Long id;
    private String name;
    private String image;

    @OneToMany(mappedBy = "genre",fetch = FetchType.LAZY)
    @JsonIgnoreProperties("genres")
    private Set<Movie> movies = new HashSet<>();


    public Genre() {
    }

    public Genre(Long id, String name, String image, Set<Movie> movies) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.movies = movies;
    }
}
