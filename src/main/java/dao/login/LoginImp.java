package dao.login;

import dao.ConnectionDB;
import models.Account;
import models.Query;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginImp implements UILogin {
    private ConnectionDB connectionDB = ConnectionDB.getInstance();

    @Override
    public boolean checkAccount(String nameAccount, String pass) {
        boolean result = false;
        Account account = selectAccount(nameAccount, pass);
        if (account != null)
            result = true;

        return result;
    }

    private Account selectAccount(String nameAccount, String namePass) {
        Account account = null;
        try {
            Connection connection = connectionDB.getConnection();
            CallableStatement call = connection.prepareCall(Query.SELECT_ACCOUNT);
            call.setString(1, nameAccount);
            call.setString(2, namePass);

            ResultSet resultSet = call.executeQuery();
            while (resultSet.next()) {
                String accountId = resultSet.getString("accountId");
                String employeeId = resultSet.getString("employeeId");
                String accountName = resultSet.getString("accountName");
                String accountPass = resultSet.getString("accountPass");

                account = new Account(accountId, employeeId, accountName, accountPass);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return account;
    }
}
