package admin.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminMemberDAO;
import dto.Member;

@WebServlet("/admin/member/list")
public class AdminMemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminMemberList() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageSize = 5;
		
		//현재 페이지
		int pageNum = 1;
		if(request.getParameter("pageNum") != null) {
			pageNum= Integer.parseInt(request.getParameter("pageNum"));
		}
		
		AdminMemberDAO dao = new AdminMemberDAO();
		
		String field = request.getParameter("field");
		String search = request.getParameter("search");
		
		//전체 게시글 수
		int count = dao.getAllcount(field, search);
		
		//넘버링
		int number = count - (pageNum-1) * pageSize;
		
		int startRow = (pageNum-1) * pageSize;
		int endRow = pageSize;
		
		ArrayList<Member> v = dao.getAllMember(startRow, endRow, field, search);
		
		request.setAttribute("v", v);
		request.setAttribute("count", count);
		request.setAttribute("field", field);
		request.setAttribute("search", search);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("number", number);
		
		RequestDispatcher dis = request.getRequestDispatcher("/admin/member/list.jsp");
		dis.forward(request, response);
	}


}