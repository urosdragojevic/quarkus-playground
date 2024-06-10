package com.urosdragojevic;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/hello")
@Consumes("application/json")
@Produces("application/json")
public class ExampleResource {
    @Inject
    BookService bookService;
    @Inject
    DomainService domainService;

    @GET
    @Path("/{id}")
    public Book getBook(@PathParam("id") Long id) {
        return bookService.getBook(id);
    }

    @PUT
    @Path("book/{id}/title/{title}")
    public Book updateBook(@PathParam("id") Long id, @PathParam("title") String title) {
        return bookService.updateBook(id, title);
    }

    @POST
    @Path("/{title}/{authorName}")
    public Book hello(@PathParam("title") String title, @PathParam("authorName") String authorName) {
        return bookService.createBook(title, authorName);
    }

    @POST
    @Path("author/{id}/book/{title}")
    public Book hello(@PathParam("id") Long id, @PathParam("title") String title) {
        return bookService.createBookForAuthor(title, id);
    }

    @DELETE
    @Path("author/{authorId}/book/{id}")
    public void deleteBook(@PathParam("authorId") Long authorId, @PathParam("id") Long id) {
        bookService.deleteBook(authorId, id);
    }

    @DELETE
    @Path("author/{authorId}")
    public void deleteAuthor(@PathParam("authorId") Long authorId) {
        bookService.deleteAuthor(authorId);
    }

    @GET
    @Path("/author/{id}")
    public Author getAuthor(@PathParam("id") Long id) {
        return bookService.getAuthor(id);
    }

    @POST
    @Path("/genres/{name}")
    public Genre createGenre(@PathParam("name") String name) {
        return bookService.createGenre(name);
    }

    @PUT
    @Path("/books/{bookId}/genres/{genreId}")
    public Book addBookGenre(@PathParam("bookId") Long bookId, @PathParam("genreId") Long genreId) {
        return bookService.addBookGenre(bookId, genreId);
    }

    @GET
    @Path("/domains")
    public List<Domain> getDomains() {
        return domainService.getDomains();
    }

    @POST
    @Path("/domains")
    public Domain createDomain(CreateDomainDto dto) {
        return domainService.createDomain(dto.name());
    }

    @PUT
    @Path("/domains/{domainId}")
    public Domain editDomain(@PathParam("domainId") String domainId, CreateDomainDto dto) {
        return domainService.editDomain(Domain.Id.fromString(domainId), dto.name());
    }
}
