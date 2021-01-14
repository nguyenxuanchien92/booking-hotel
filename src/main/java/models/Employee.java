package models;

import java.util.Date;
import java.util.Random;

public class Employee {

    private String firstName;
    private String lastName;
    private String employeeId;
    private Date dob;
    private String idCard;
    private String office;

    public Employee(String firstName, String lastName, String employeeId, Date dob, String idCard, String office) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.dob = dob;
        this.idCard = idCard;
        this.office = office;
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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

}
