package controllers.login;

import dao.account.AccountImp;
import dao.account.UIAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UIAccount imp = new AccountImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login-layout/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String txtNameAccount = req.getParameter("txtNameAccount");
        String pass = req.getParameter("txtPassWord");
        boolean result = imp.checkAccount(txtNameAccount, pass);
        if (result) {
            HttpSession session = req.getSession(false);
            session.setAttribute("Account", txtNameAccount);
            session.setAttribute("Pass", pass);

            resp.sendRedirect("/home");
        } else {
            resp.sendRedirect("login");
        }
    }

}
