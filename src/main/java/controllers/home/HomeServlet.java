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
import java.util.List;

@WebServlet(urlPatterns = "/home")

public class HomeServlet extends HttpServlet {
    UIHome impHome = new HomeImp();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "home":
                displayListRoom(req, resp);
                break;
            case "create":

                break;
            case "price":

                break;
            default:
                displayListRoom(req, resp);
                break;
        }
    }

    private void displayListRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Room> roomList = impHome.displayRoomEmpty();
        HttpSession session = req.getSession();
        session.setAttribute("roomList",roomList);
        req.getRequestDispatcher("home-layout/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
