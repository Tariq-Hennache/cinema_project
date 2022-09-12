package com.example.cinema_project.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity(name = "screens")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "capacity")
    private int capacity;



    @ManyToMany
    @JoinTable(
            name = "screenings",
            joinColumns = {@JoinColumn(name = "screen_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "movie_id", nullable = false)}
    )

    @JsonIgnoreProperties({"screens"})
    private List<Movie> movies;

    private  List<Customer> customers;


    public Screen(int capacity) {
        this.capacity = capacity;
    }

    public Screen(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }


}