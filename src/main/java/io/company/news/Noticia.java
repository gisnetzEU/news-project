package io.company.news;

//https://projectlombok.org/features/all
import lombok.*;

import java.util.Date;

import javax.persistence.*;


@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
@Entity(name="Noticia")
@Table(name="NOTICIA_TABLE")
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="NOTICIA_ID")
    private long noticiaId;
    @Column(name="NOTICIA_TITLE")
    private String title;
    private String author;
    private String content;
    @Column(name="POSTED_DATE")
    private Date postedDate;
    @Column(name="ISBN")
    private String isbn;

    public Noticia(String title, String author, String content, Date postedDate, String isbn) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.postedDate = postedDate;
        this.isbn = isbn;
    }
}