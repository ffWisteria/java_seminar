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

@WebServlet("/microposts/edit")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");

    String content = request.getParameter("content");
    String micropostID = request.getParameter("id");

    Micropost micropost = new Micropost(
            micropostID,
            null,null,
            content,
            User.getCurrentUser(request).getId()
    );

    micropost.updateMicropost();

    response.sendRedirect("/microposts");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //リクエストパラメーターの取得
        String micropostID = request.getParameter("id");
        //リクエストスコープに保存
        request.setAttribute("id", micropostID);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/micropost/edit.jsp");
        dispatcher.forward(request, response);
    }
}
