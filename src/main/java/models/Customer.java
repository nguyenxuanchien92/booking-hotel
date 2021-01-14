package models;

import java.util.Date;
import java.util.Random;

public class Customer {
    private String firstName;
    private String lastName;
    private String roomId;
    private String employeeId;
    private Date dob;
    private String idCard;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Customer(){}

    public Customer(String firstName, String lastName, Date dob, String idCard) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.idCard = idCard;
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
