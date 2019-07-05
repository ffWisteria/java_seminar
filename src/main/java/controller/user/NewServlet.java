package controller.user;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/new")
public class NewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータの文字コードを指定
        request.setCharacterEncoding("UTF-8");

        // リクエストパラメータの取得
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // 取得したデータの印字
        System.out.println(name);
        System.out.println(email);
        System.out.println(password);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/new.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/new.jsp");
        dispatcher.forward(request, response);
    }
}
