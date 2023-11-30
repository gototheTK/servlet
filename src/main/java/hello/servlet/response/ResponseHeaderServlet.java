package hello.servlet.response;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //[status-line]
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        //[response-headers]
        resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header", "hello");

        // [Header 편의 메서드]
        content(resp);
        cookie(resp);
        redirect(resp);

        PrintWriter writer = resp.getWriter();
        writer.println("안녕하세요");
    }

    private void content(HttpServletResponse response) {
        response.setContentType("text/plan");
        response.setCharacterEncoding("utf-8");
    }
    
    private void cookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("myCookie", "cookie");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_FOUND);
        response.sendRedirect("/basic/helloForm.html");
    }

}
