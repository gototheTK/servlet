package hello.servlet.hello.servlet.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import hello.servlet.hello.servlet.domain.Member;
import hello.servlet.hello.servlet.domain.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberFormServlet = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        Member member = new Member(username, age);
        memberFormServlet.save(member);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter w = resp.getWriter();
        w.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n"
                + "  <meta name=\"viewport\" \ncontent=\"width=device-width, initial-scale=1.0\">"
                + "  <title>Document</title>\n"
                + "</head>\n"
                + "<body>\n성공"
                + "<ul>\n"
                + "     <li>id=" + member.getId() + "</li>\n"
                + "     <li>username=" + member.getUsername() + "</li>\n"
                + "     <li>age=" + member.getAge() + "</li>\n"
                + "</ul>"
                + "<a href=\"/index.html\">메인</a>\n"
                + "</body>" + "</html>\n");

    }

}
