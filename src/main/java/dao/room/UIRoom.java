package dao.room;

import models.Room;

import java.util.Date;
import java.util.List;

public interface UIRoom {
    List<Room> displayRoomEmpty();

    List<Room> displayRoomRent();

    List<Room> findCustomerByName(String nameCus);

    boolean deleteRoomRent(String roomId);

    Room findCustomerByRoomId(String roomId);

    boolean updateRoomDetail(String roomId, Date checkIn, Date chekOut, String CMT);
}
