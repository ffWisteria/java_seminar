package controller.micropost;

import model.micropost.Micropost;
import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/microposts/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String micropostID = request.getParameter("id");
        Micropost micropost = new Micropost(
               micropostID,
               null,null,
               null, User.getCurrentUser(request).getId()
        );
        micropost.destroyMicropost();

        response.sendRedirect("/microposts");
    }
}
