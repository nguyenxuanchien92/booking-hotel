package dao.room;

import models.Room;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface UIRoom {
    List<Room> displayRoomEmpty();

    List<Room> displayRoomRent();

    List<Room> findCustomerByName(String nameCus, String CMT);

    boolean deleteRoomRent(String roomId, String CMT);

    Room findCustomerByRoomId(String roomId);

    boolean updateRoomDetail(String roomId, LocalDate checkIn, LocalDate chekOut, String CMT);
}
