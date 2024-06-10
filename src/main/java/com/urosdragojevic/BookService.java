package com.urosdragojevic;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BookService {
    @Inject
    EntityManager em;

    @Transactional
    public Book createBook(String title, String authorName) {
        Book book = new Book();
        book.setTitle(title);
        Author author = new Author();
        author.setName(authorName);
        author.addBook(book);
        em.persist(author);
        return book;
    }

    @Transactional
    public Book createBookForAuthor(String title, Long authorId) {
        Book book = new Book();
        book.setTitle(title);
        em.persist(book);
        Author author = em.find(Author.class, authorId);
        author.addBook(book);
        em.persist(author);
        return book;
    }

    public Book getBook(Long id) {
        return em.find(Book.class, id);
    }

    @Transactional
    public Book updateBook(Long id, String title) {
        Book found = em.find(Book.class, id);
        found.setTitle(title);
        em.persist(found);
        return found;
    }

    public Author getAuthor(Long id) {
        return em.find(Author.class, id);
    }

    @Transactional
    public void deleteBook(Long authorId, Long id) {
        Book found = em.find(Book.class, id);
        Author author = em.find(Author.class, authorId);
        author.removeBook(found);
        em.persist(author);
        em.remove(found);
    }

    @Transactional
    public void deleteAuthor(Long authorId) {
        Author author = em.find(Author.class, authorId);
        em.remove(author);
    }

    @Transactional
    public Genre createGenre(String name) {
        Genre genre = new Genre();
        genre.setName(name);
        em.persist(genre);
        return genre;
    }

    @Transactional
    public Book addBookGenre(Long bookId, Long genreId) {
        Book book = em.find(Book.class, bookId);
        Genre genre = em.find(Genre.class, genreId);
        book.addGenre(genre);
        em.persist(book);
        return book;
    }
}
