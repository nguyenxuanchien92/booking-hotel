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

        List<Room> roomCus = impHome.findCustomerByName(name);
        req.setAttribute("roomRents", roomCus);
        req.getRequestDispatcher("home-layout/views/displayRoomRent.jsp").forward(req, resp);
    }
    //endregion

    //region DELETE
    private void deleteRoomRent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roomId = req.getParameter("id");
        boolean result =impHome.deleteRoomRent(roomId);
        if(result) {
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
        req.setAttribute("room",room);
        req.getRequestDispatcher("home-layout/views/roomDetail.jsp").forward(req, resp);
    }

    private void updateRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    //endregion
}
