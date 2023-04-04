package controller.moim;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.Moim;
import data.Reply;
import data.User;
import repository.Moims;

@WebServlet("/moim/reply")
public class MoimReplyController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();

		User logonUser = (User) req.getSession().getAttribute("logonUser");

		String id = logonUser.getId();
		System.out.println(id);
		

		String ment = req.getParameter("ment");
		System.out.println(ment);
        String target = req.getParameter("id");
		Map<String, Object> params = new HashMap<>();

		params.put("moimId", target);
		params.put("writer", logonUser.getId());
		params.put("ment", ment);
		
		int r = sqlSession.insert("replys.create", params);
		
		
		

		resp.sendRedirect("/moim/detail");
		 
	}

}
