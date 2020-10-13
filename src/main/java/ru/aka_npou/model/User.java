package ru.aka_npou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String email;
    private String first_name;
    private String last_name;
    private String gender;
    private Long birth_date;


    public void setKeyValue(String keyStr, Object keyValue) throws Exception {
        switch (keyStr) {
            case "id":
                id = (Long) keyValue;
                break;
            case "email":
                email = (String) keyValue;
                break;
            case "first_name":
                first_name = (String) keyValue;
                break;
            case "last_name":
                last_name = (String) keyValue;
                break;
            case "gender":
                gender = (String) keyValue;
                break;
            case "birth_date":
                birth_date = (Long) keyValue;
                break;
        }
    }

    public String toJson() {
        return "{\"id\":" + id +
                ",\"email\":\"" + email +
                "\",\"first_name\":\"" + first_name +
                "\",\"last_name\":\"" + last_name +
                "\",\"gender\":\"" + gender +
                "\",\"birth_date\":" + birth_date + "}";
    }

}
