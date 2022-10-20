package jsptest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import jsptest.model.BoardDao;
import jsptest.model.BoardDto;


@WebServlet("/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public view() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int bno=Integer.parseInt(request.getParameter("bno"));
		
		BoardDao dao = new BoardDao();
		
		BoardDto dto=dao.getboard(bno);
		
		JSONObject object = new JSONObject();
		object.put("btitle", dto.getBtitle());
		object.put("bcontent", dto.getBcontent());
		object.put("bwriter", dto.getBwriter());
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(object);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
