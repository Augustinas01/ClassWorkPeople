package objects;

import java.util.HashMap;

public class User {

    public static final String ID = "id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String EMAIL = "email";
    public static final String GENDER = "gender";
    public static final String COUNTRY = "country";



    String id,firstName,lastName,email,gender,country;


    public User(HashMap<String,String> info){
        setInfo(info);
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    private void setInfo(HashMap<String,String> info){
        info.forEach((key,stat) -> {
            switch (key){
                case ID -> this.id = stat;
                case FIRST_NAME -> this.firstName = stat;
                case LAST_NAME -> this.lastName = stat;
                case EMAIL -> this.email = stat;
                case GENDER -> this.gender = stat;
                case COUNTRY -> this.country = stat;
            }
        });
    }





}
