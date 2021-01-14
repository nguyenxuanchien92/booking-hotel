package dao.home;

import models.Room;

import java.util.List;

public interface UIHome {
    List<Room> displayRoomEmpty();
    List<Room> displayRoomRent();
    List<Room> findCustomerByName(String nameCus);
    boolean deleteRoomRent(String roomId);
    Room findCustomerByRoomId(String roomId);
}
