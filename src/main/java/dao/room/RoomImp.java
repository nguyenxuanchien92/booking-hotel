package dao.room;

import dao.ConnectionDB;
import models.Customer;
import models.Query;
import models.Room;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomImp implements UIRoom {

    ConnectionDB connectionDB = ConnectionDB.getInstance();

    @Override
    public List<Room> displayRoomEmpty() {
        List<Room> roomList = new ArrayList<>();
        try {
            Connection connection = connectionDB.getConnection();
            CallableStatement call = connection.prepareCall(Query.SELECT_ROOM_EMPTY);
            ResultSet resultSet = call.executeQuery();


            while (resultSet.next()) {
                String roomId = resultSet.getString("id");
                boolean state = resultSet.getBoolean("state");
                roomList.add(new Room(roomId, state));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return roomList;
    }

    @Override
    public List<Room> displayRoomRent() {
        List<Room> roomRent = new ArrayList<>();

        try {
            Connection connection = connectionDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall(Query.SELECT_ROOM_RENT);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String roomId = resultSet.getString("id");
                boolean state = resultSet.getBoolean("state");
                Date checkIn = resultSet.getDate("dateRent");
                Date checkOut = resultSet.getDate("checkOut");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String CMT = resultSet.getString("CMT");

                Room room = new Room(roomId, checkIn, checkOut, state, new Customer(firstName, lastName, CMT));
                roomRent.add(room);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return roomRent;
    }

    @Override
    public List<Room> findCustomerByName(String nameCus, String CMT) {
        List<Room> roomCus = new ArrayList<>();
        try {
            Connection connection = connectionDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall(Query.FIND_CUS_BY_NAME);
            callableStatement.setString(1, nameCus);
            callableStatement.setString(2, CMT);
            ResultSet result = callableStatement.executeQuery();

            while (result.next()) {
                String roomId = result.getString("id");
                boolean state = result.getBoolean("state");
                Date checkIn = result.getDate("dateRent");
                Date checkOut = result.getDate("checkOut");
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String idCard = result.getString("CMT");

                Room room = new Room(roomId, checkIn, checkOut, state, new Customer(firstName, lastName, idCard));
                roomCus.add(room);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return roomCus;
    }

    @Override
    public boolean deleteRoomRent(String roomId, String CMT) {
        boolean result = false;
        try {
            Connection connection = connectionDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall(Query.DELETE_ROOM_RENT);
            callableStatement.setString(1, roomId);
            callableStatement.setString(2, CMT);
            result = callableStatement.executeUpdate() > 0;

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Room findCustomerByRoomId(String roomId) {
        Room room = null;
        try {
            Connection connection = connectionDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall(Query.FIND_CUSTOMER_BY_ROOM_ID);
            callableStatement.setString(1, roomId);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                boolean state = resultSet.getBoolean("state");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                Date checkIn = resultSet.getDate("dateRent");
                Date checkOut = resultSet.getDate("checkOut");
                String CMT = resultSet.getString("CMT");

                room = new Room(id, checkIn, checkOut, state, new Customer(firstName, lastName, CMT));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return room;
    }

    @Override
    public boolean updateRoomDetail(String roomId, LocalDate checkIn, LocalDate chekOut, String CMT) {
        boolean result = false;

        try {
            Connection connection = connectionDB.getConnection();
            CallableStatement callableStatement = connection.prepareCall(Query.UPDATE_ROOM_DETAIL);
            callableStatement.setString(1, roomId);
            callableStatement.setDate(2, java.sql.Date.valueOf(checkIn));
            callableStatement.setDate(3, java.sql.Date.valueOf(chekOut));
            callableStatement.setString(4, CMT);

            result = callableStatement.executeUpdate() > 0;
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }
}
