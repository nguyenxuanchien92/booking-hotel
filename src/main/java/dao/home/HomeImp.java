package dao.home;

import dao.ConnectionDB;
import models.Query;
import models.Room;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeImp implements UIHome {

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
}
