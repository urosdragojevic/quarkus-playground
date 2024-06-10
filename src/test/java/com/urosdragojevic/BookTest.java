package com.urosdragojevic;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class BookTest {
    @Test
    void equals() {
        EqualsVerifier.forClass(Book.class)
                .suppress(
                        Warning.SURROGATE_KEY,
                        Warning.IDENTICAL_COPY_FOR_VERSIONED_ENTITY,
                        Warning.STRICT_HASHCODE
                )
                .verify();
    }

    @Test
    void reflexivity() {
        Book book = new Book();
        Book anotherBook = new Book();
        assertNotEquals(book, anotherBook);
    }

    @Test
    void symmetric() {
        Book book = new Book();
        book.setId(1L);
        Book anotherBook = new Book();
        book.setId(1L);
        assertEquals(book.equals(anotherBook), anotherBook.equals(book));
    }

    @Test
    void transitive() {
        Book x = new Book();
        x.setId(1L);
        Book y = new Book();
        y.setId(1L);
        Book z = new Book();
        z.setId(1L);
        assertEquals(x, y);
        assertEquals(y, z);
        assertEquals(x, z);
    }

    @Test
    void consistent() {
        Book x = new Book();
        x.setId(1L);
        Book y = new Book();
        y.setId(1L);
        assertEquals(x, y);
        x.setTitle("Not important");
        assertEquals(x, y);
        y.setTitle("Not important");
        assertEquals(x, y);
    }

    @Test
    void nullCheck() {
        Book x = new Book();
        x.setId(1L);
        Book y =  null;
        assertNotEquals(x, y);
    }
}
