package ru.aka_npou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Location {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String place;
    private String country;
    private String city;
    private int distance;

    public String toJson() {
        return "{\"id\": "+id+",\"place\": \""+place+"\",\"country\": \""+country+"\",\"city\": \""+city+"\",\"distance\": "+distance+"}";
    }
}
