package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.starthere.logging.Loggable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "book")
public class Book extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false,
            unique = true)
    private String isbn;
    private int copy;

    @ManyToOne
    @JoinColumn(name = "sectionid")
    @JsonIgnoreProperties("section")
    private Section section;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "wrote",
            joinColumns = {@JoinColumn(name = "bookid")},
            inverseJoinColumns = {@JoinColumn(name = "authorid")})
    @JsonIgnoreProperties("authors")
    private List<Author> authors = new ArrayList<>();

    public Book()
    {
    }

    public Book(String title, String isbn, int copy, Section section, List<Author> authors)
    {
        this.title = title;
        this.isbn = isbn;
        this.copy = copy;
        this.section = section;
        this.authors = authors;
    }

    public long getBookid()
    {
        return bookid;
    }

    public void setBookid(long bookid)
    {
        this.bookid = bookid;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public int getCopy()
    {
        return copy;
    }

    public void setCopy(int copy)
    {
        this.copy = copy;
    }

    public Section getSection()
    {
        return section;
    }

    public void setSection(Section section)
    {
        this.section = section;
    }

    public List<Author> getAuthors()
    {
        return authors;
    }

    public void setAuthors(List<Author> authors)
    {
        this.authors = authors;
    }
}
