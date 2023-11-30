package hello.servlet.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = " requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

        ServletInputStream inputStream = req.getInputStream();
        String messageString = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        HelloData messageBody = objectMapper.readValue(messageString, HelloData.class);

        resp.getWriter().write(messageString);
        
    }

}
