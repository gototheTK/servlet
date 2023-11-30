package hello.servlet.request;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/requestparam?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // TODO Auto-generated method stub

        System.out.println("[전체 파라미터 조회] - start");

        req.getParameterNames().asIterator()
            .forEachRemaining(paramName -> System.out.println(paramName + "=" + req.getParameter(paramName)));

        System.out.println("[전체 라마티저 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = req.getParameter("username");
        String age = req.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = req.getParameterValues("username");

        for (String name : usernames) {
            System.out.println("uername = " + name);
        }

        res.getWriter().write("OK");

    }
    
}
