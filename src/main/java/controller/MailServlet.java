package controller;

import util.Mailer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/send-mail")
public class MailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/bai2/send-mail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String body = request.getParameter("body");

        try {
            Mailer.send(to, subject, body);
            request.setAttribute("message", "Gửi email thành công!");
            request.setAttribute("error", false);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Lỗi: " + e.getMessage());
            request.setAttribute("error", true);
        }
        request.getRequestDispatcher("/bai2/send-mail.jsp").forward(request, response);
    }
}
