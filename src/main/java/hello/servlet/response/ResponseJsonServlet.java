package hello.servlet.response;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.servlet.request.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // Content-Type: application/json
        res.setContentType("application/json");
        res.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("Jo");
        helloData.setAge(20);

        // {"username":"Jo", "age":20}
        String result = objectMapper.writeValueAsString(helloData);
        res.getWriter().write(result);
    }

}
