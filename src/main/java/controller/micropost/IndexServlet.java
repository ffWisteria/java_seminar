package controller.micropost;

import model.micropost.Micropost;
import model.micropost.Repository;
import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/microposts")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userID = User.getCurrentUser(request).getId();
        ArrayList<Micropost> myMicroposts = Repository.selectMyMicropost(userID);
        ArrayList<Micropost> othersMicroposts = Repository.selectOtherMicropost(userID);

        // リクエストスコープに保存
        request.setAttribute("myMicroposts", myMicroposts);
        request.setAttribute("othersMicroposts", othersMicroposts);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/micropost/index.jsp");
        dispatcher.forward(request, response);
    }
}
