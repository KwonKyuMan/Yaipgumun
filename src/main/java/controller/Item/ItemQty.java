package controller.Item;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDAO;
import dto.Item;

@WebServlet("/item/itemqty")
public class ItemQty extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ItemQty() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int it_uid = Integer.parseInt(request.getParameter("it_uid"));
		System.out.println(it_uid);
		ItemDAO dao = new ItemDAO();
		
        Item i = dao.oneItem(it_uid);
        
        //request.setAttribute("i", i);

        // JSP 파일로 포워딩
        RequestDispatcher dis = request.getRequestDispatcher("/cart/cartlist.jsp");
        dis.forward(request, response);
	}

}
