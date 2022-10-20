package com.demo.entities;
import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name="movies")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMovie")
    private Long id;

    private String image;

    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date creationDate;

    @Max(5) @Min(1)
    private int calification;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="movie_character",
                joinColumns = @JoinColumn(name="movie_id"),
                inverseJoinColumns = @JoinColumn(name="character_id"))
    @JsonIgnoreProperties("movies")
    private Set<Character> characters = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="genre_id", referencedColumnName = "idGenre")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Genre genre;

    public Movie() {
    }

    public Movie(Long id, String image, String title, Date creationDate, int calification, Set<Character> characters, Genre genre) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.creationDate = creationDate;
        this.calification = calification;
        this.characters = characters;
        this.genre = genre;
    }


}
