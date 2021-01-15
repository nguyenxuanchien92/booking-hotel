package controllers.home;

import dao.room.RoomImp;
import dao.room.UIRoom;
import models.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/home")

public class HomeServlet extends HttpServlet {
    private UIRoom impHome = new RoomImp();

    //region CONTROLLER
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "home":
                displayListRoomRent(req, resp);
                break;
            case "search":
                searchCustomerByName(req, resp);
                break;
            case "edit":
                showEditRoomForm(req, resp);
                break;
            default:
                displayListRoomEmpty(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {

            case "delete":
                deleteRoomRent(req, resp);
                break;
            case "edit":
                updateRoom(req, resp);
                break;
            default:
                break;
        }
    }
    //endregion

    //region DISPLAY
    private void displayListRoomRent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Room> roomRents = impHome.displayRoomRent();
        req.setAttribute("roomRents", roomRents);
        RequestDispatcher dispatcher = req.getRequestDispatcher("home-layout/views/displayRoomRent.jsp");
        dispatcher.forward(req, resp);
    }

    private void displayListRoomEmpty(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Room> roomList = impHome.displayRoomEmpty();
        req.setAttribute("roomList", roomList);
        req.getRequestDispatcher("home-layout/views/home.jsp").forward(req, resp);
    }

    private void searchCustomerByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("searchTxt");
        String CMT = req.getParameter("CMT");

        List<Room> roomCus = impHome.findCustomerByName(name,CMT);
        req.setAttribute("roomRents", roomCus);
        req.getRequestDispatcher("home-layout/views/displayRoomRent.jsp").forward(req, resp);
    }
    //endregion

    //region DELETE
    private void deleteRoomRent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roomId = req.getParameter("id");
        String CMT = req.getParameter("cmt");
        boolean result = impHome.deleteRoomRent(roomId, CMT);
        if (result) {
            List<Room> roomRents = impHome.displayRoomRent();
            req.setAttribute("roomRents", roomRents);
            req.getRequestDispatcher("home-layout/views/displayRoomRent.jsp").forward(req, resp);
        }
    }
    //endregion

    //region EDIT
    private void showEditRoomForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String roomId = req.getParameter("id");
        Room room = impHome.findCustomerByRoomId(roomId);
        req.setAttribute("room", room);
        req.getRequestDispatcher("home-layout/views/roomDetail.jsp").forward(req, resp);
    }

    private void updateRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idRoom = request.getParameter("txtRoomId");
        String idCard = request.getParameter("CMT");

        String strDateCheckIn = request.getParameter("dateCheckIn");
        LocalDate dateCheckIn = convertDate(strDateCheckIn);

        String strDateCheckout = request.getParameter("dateCheckOut");
        LocalDate dateCheckOut = convertDate(strDateCheckout);


        boolean result = validateDate(dateCheckIn, dateCheckOut);
        if (result) {
            boolean valid = impHome.updateRoomDetail(idRoom, dateCheckIn,
                    dateCheckOut, idCard);
            if (valid) {
                System.out.println("thành công");
            }
        }
    }

    private LocalDate convertDate(String strDate) {
        LocalDate date = null;
        String pattern = "MM/DD/YYYY";
        date = LocalDate.parse(strDate);

        return date;
    }

    private boolean validateDate(LocalDate checkIn, LocalDate checkOut) {
        boolean result = false;

//        LocalDate currentDate = convertDate(getDateTimeNow());
        LocalDate currentDate = getDateTimeNow().toLocalDate();

        if (checkIn.getDayOfYear() - currentDate.getDayOfYear() < 0) {
            return false;
        } else {
            if (checkIn.getDayOfYear() - checkOut.getDayOfYear() < 0) {
                result = true;
            }
            return result;
        }
    }

    private LocalDateTime getDateTimeNow() {
        String pattern = "MM/DD/YYYY";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.now();

        //String date = formatter.format(localDateTime);
        return localDateTime;
    }


    //endregion
}
