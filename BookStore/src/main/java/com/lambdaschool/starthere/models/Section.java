package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.starthere.logging.Loggable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "section")
public class Section extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionid;

    @Column(nullable = false,
            unique = true)
    private String name;

    @OneToMany(mappedBy = "section")
    @JsonIgnoreProperties("books")
    private List<Book> books = new ArrayList<>();

    public Section()
    {
    }

    public Section(String name, List<Book> books)
    {
        this.name = name;
        this.books = books;
    }

    public long getSectionid()
    {
        return sectionid;
    }

    public void setSectionid(long sectionid)
    {
        this.sectionid = sectionid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Book> getBooks()
    {
        return books;
    }

    public void setBooks(List<Book> books)
    {
        this.books = books;
    }

    @Override
    public String toString()
    {
        return "Section{" +
                "sectionid=" + sectionid +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
