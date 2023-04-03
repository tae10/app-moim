package controller.moim;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.User;
import repository.Moims;

@WebServlet("/moim/create-task")
public class MoimCreateTaskController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		UUID uuid = UUID.randomUUID();
		String id = uuid.toString().split("-")[0];
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("logonUser");
		String managerId =user.getId();

		String event = req.getParameter("event");
		String type = req.getParameter("type");
		String cate = req.getParameter("cate");
		String description = req.getParameter("description");
		
		String date = req.getParameter("date");
		String begin = req.getParameter("begin");
		String beginDate =date  +"  " +begin;

		String  end = req.getParameter("end");
		String endDate =date+"  "+begin;

		int maxPerson = Integer.parseInt(req.getParameter("maxPerson"));
		
		int r =Moims.create(id, managerId, event, type, cate, description, maxPerson, beginDate, endDate);
		if(r==1) {
			resp.sendRedirect("/moim/detail?id="+id);  //페이지 하나더만들지는 선택 바로 보내줘도 되고
//			req.getRequestDispatcher("/WEB-INF/views/moim/create-success.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("moim/create?cause=error");
		}
		

	}

}
