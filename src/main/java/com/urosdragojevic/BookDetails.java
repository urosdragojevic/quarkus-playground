package com.urosdragojevic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

@Entity
public class BookDetails {
    @Id
    private Long id;
    @OneToOne
    @MapsId
    private Book book;
    private LocalDate publishingDate;
    private String summary;
}
