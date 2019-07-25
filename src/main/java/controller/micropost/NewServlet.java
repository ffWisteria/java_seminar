package controller.micropost;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/microposts/new")
public class NewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータの文字コードを指定
        request.setCharacterEncoding("UTF-8");

        // リクエストパラメータの取得
        String content = request.getParameter("content");

        Micropost micropost = new Micropost(
                null,
                null,
                null,
                name,
                email,
                password
        );

        //userをDBに追加
        user.createUser();

        //リクエストスコープにインスタンスを保存
        //"user"という名前でuserインスタンスを保存
        request.setAttribute("user",user);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/new.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/micropost/new.jsp");
        dispatcher.forward(request, response);
    }
}
