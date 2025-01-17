package controller.fairtrade;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/fairtrade/anotherinfo")
public class Anotherinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Anotherinfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("anotherinfo.jsp");
		dis.forward(request, response);
	}
}
