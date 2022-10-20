package jsptest.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import jsptest.model.BoardDao;
import jsptest.model.BoardDto;


@WebServlet("/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public list() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BoardDao dao= new BoardDao();
		
		ArrayList<BoardDto> list=dao.getlist();
		JSONArray array = new JSONArray();
		
		for(BoardDto dto : list) {
			JSONObject object = new JSONObject();
			object.put("bno", dto.getBno());
			object.put("btitle", dto.getBtitle());
			object.put("bwriter", dto.getBwriter());
			object.put("bdate", dto.getBdate());
			object.put("bview", dto.getBview());
			array.add(object);
		}
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
