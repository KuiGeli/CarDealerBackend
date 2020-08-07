package com.aouto.CarDealer.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String mark;

    @Column
    private String type;

    @Column
    private String price;

    @OneToMany(mappedBy = "auto")
    private List<Photo> photos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
