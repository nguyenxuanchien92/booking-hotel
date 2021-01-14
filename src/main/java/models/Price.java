package models;

public class Price {
    private String roomId;
    private String typeRoom;
    private long price;

    public Price(String roomId, String typeRoom, long price) {
        this.roomId = roomId;
        this.typeRoom = typeRoom;
        this.price = price;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
