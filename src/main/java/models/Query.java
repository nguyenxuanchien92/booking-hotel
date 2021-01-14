package models;

public class Query {
    public static String SELECT_ACCOUNT = "call selectAccount(?,?)";
    public static String SELECT_ROOM_EMPTY = "call findRoomEmpty()";
    public static String SELECT_ROOM_RENT = "call findRoomRent";
    public static String FIND_CUS_BY_NAME = "call findCustomerByName(?)";
    public static String DELETE_ROOM_RENT = "call deleteRoomRent(?)";
    public static String FIND_CUSTOMER_BY_ROOM_ID = "call findCustomerByRoomId(?)";
}
