package com.youcode.shimatch.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.*;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "city")
    private String city;

    @Column(name= "country")
    private String country;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "win")
    private Integer win;

    @Column(name = "draw")
    private Integer draw;

    @Column(name = "lose")
    private Integer lose;

    @OneToMany(mappedBy = "team")
    private List<User> users = new ArrayList<>();

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "capitaine_id")
    private User capitaine;
    @JsonIgnore
    public User getCapitaine() {
        return capitaine;
    }

    public void setCapitaine(User capitaine) {
        this.capitaine = capitaine;
    }

    @JsonIgnore
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", win=" + win +
                ", draw=" + draw +
                ", lose=" + lose +
                '}';
    }
}
