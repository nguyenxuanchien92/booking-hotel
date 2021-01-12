package models;

public class Account {
    private String accountId;
    private String employeeId;
    private String accountName;
    private String accountPass;

    public Account(String accountId, String employeeId, String accountName, String accountPass) {
        this.accountId = accountId;
        this.employeeId = employeeId;
        this.accountName = accountName;
        this.accountPass = accountPass;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPass() {
        return accountPass;
    }

    public void setAccountPass(String accountPass) {
        this.accountPass = accountPass;
    }
}
