package models;

import java.util.Date;
import java.util.Random;

public class Person {
    private String firstName;
    private String lastName;
    private Date dob;
    private String idCard;

    public Person(){}

    public Person(String firstName, String lastName, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.idCard = randomIdCard();
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    private String randomIdCard(){
        String idCard = (new Random()).nextInt() + "A";
        return idCard;
    }

    public String getIdCard(){
        return idCard;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
