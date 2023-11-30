package hello.servlet.hello.servlet.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import hello.servlet.hello.servlet.domain.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "memberFormServlet", urlPatterns = "/servlet/members/new-form")
public class MemberFormServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter w = resp.getWriter();
        w.write("<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" \ncontent=\"width=device-width, initial-scale=1.0\">"
                + "    <title>Document</title>\n" + "</head>\n" + "<body>\n"
                + "<form action=\"/servlet/members/save\" method=\"post\">\n"
                + "    username: <input type=\"text\" name=\"username\"/>\n"
                + "    age:      <input type=\"text\" name=\"age\"/>\n" + "    <button type=\"submit\">전송</button>\n"
                + "</form>\n" + "</b>" + "</html>\n");

    }

}
