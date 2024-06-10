package com.urosdragojevic;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        this.books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
        book.setAuthor(null);
    }

    public void setName(String name) {
        this.name = name;
    }
}
