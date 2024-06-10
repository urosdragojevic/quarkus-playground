package com.urosdragojevic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Author author;
    @ManyToMany
    @JoinTable(name = "book_genres")
    private Set<Genre> genres = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
        genre.getBooks().add(this);
    }

    public void removeGenre(Genre genre) {
        this.genres.remove(genre);
        genre.getBooks().remove(this);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;

        return getId()!= null && getId().equals(book.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
