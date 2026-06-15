package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if(cookies != null) {
            for(Cookie cookie: cookies) {
                if(cookie.getName().equals("user")) {
                    String userInfoStr = cookie.getValue();
                    String[] userInfo = userInfoStr.split("-");
                    if (userInfo.length >= 2) {
                        req.setAttribute("username", userInfo[0]);
                        req.setAttribute("password", userInfo[1]);
                    }
                }
            }
        }
        req.getRequestDispatcher("/bai3/form_login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember-me");
        if(username.equalsIgnoreCase("FPT") && password.equals("poly")) {
            req.setAttribute("message", "Login successfully!");
            req.getSession().setAttribute("username", username); // session

            if(remember != null) {
                String userInfo = username + "-" + password;

                Cookie cookie = new Cookie("user", userInfo);
                cookie.setMaxAge(30*24*60*60); // hiệu lực 30 ngày
                cookie.setPath("/"); // hiệu lực toàn ứng dụng
                // Gửi về trình duyệt
                resp.addCookie(cookie); // cookie
            }
        } else {
            req.setAttribute("message", "Invalid login info!");
        }
        req.getRequestDispatcher("/bai3/form_login.jsp").forward(req, resp);
    }
}
