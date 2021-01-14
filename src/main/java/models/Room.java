package models;

import java.util.Date;

public class Room {
    private String roomId;
    private Date dateOfRent;
    private Date checkOutDate;
    private boolean state;
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Room(String roomId, boolean state) {
        this.roomId = roomId;
        this.state = state;
    }

    public Room(String roomId, Date dateOfRent, Date checkOutDate, boolean state, Person person) {
        this.roomId = roomId;
        this.dateOfRent = dateOfRent;
        this.checkOutDate = checkOutDate;
        this.state = state;
        this.person = person;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Date getDateOfRent() {
        return dateOfRent;
    }

    public void setDateOfRent(Date dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
