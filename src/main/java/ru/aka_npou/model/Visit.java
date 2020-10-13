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
public class Visit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int location;
    private int user;
    private long visited_at;
    private int mark;

    private String country;
    private int distance;
    private String place;

    public String toJson() {
        return "{\"id\": "+id+",\"location\": "+location+",\"user\": "+user+",\"visited_at\": "+visited_at+",\"mark\": "+mark+"}";
    }

    public String toJsonVisits() {
        return "{\"mark\":" + mark + ",\"visited_at\":" + visited_at + ",\"place\":\"" + place + "\"}";
        //return "{\"mark\":" + mark + ",\"visited_at\":" + visited_at + ",\"place\":\"" + Data.locationsArray[location].place + "\"}";
    }
}
