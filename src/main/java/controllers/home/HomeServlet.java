package controllers.home;

import dao.home.HomeImp;
import dao.home.UIHome;
import models.Room;

import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

@WebServlet(urlPatterns = "/home")

public class HomeServlet extends HttpServlet {
    private UIHome impHome = new HomeImp();


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

                break;
            default:
                displayListRoomEmpty(req, resp);
                break;
        }
    }

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {

            case "delete":
                deleteRoomRent(req, resp);
                break;
            case "edit":
                editRoomRent(req, resp);
                break;
            default:
                break;
        }
    }

    private void deleteRoomRent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roomId = req.getParameter("id");
        boolean result =impHome.deleteRoomRent(roomId);
        if(result) {
            List<Room> roomRents = impHome.displayRoomRent();
            req.setAttribute("roomRents", roomRents);
            req.getRequestDispatcher("home-layout/views/displayRoomRent.jsp").forward(req, resp);
        }
    }

    private void editRoomRent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String roomId = req.getParameter("id");
        Room room = impHome.findCustomerByRoomId(roomId);
        req.setAttribute("room",room);
        req.getRequestDispatcher("home-layout/views/roomDetail.jsp").forward(req, resp);
    }

    private void searchCustomerByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("searchTxt");

        List<Room> roomCus = impHome.findCustomerByName(name);
        req.setAttribute("roomRents", roomCus);
        req.getRequestDispatcher("home-layout/views/displayRoomRent.jsp").forward(req, resp);
    }
}
