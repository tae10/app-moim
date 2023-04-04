package controller.moim;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.Reply;
import data.User;

@WebServlet("/moim/add-reply-task")
public class MoimReplyController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession(true);

		User logonUser = (User)req.getSession().getAttribute("logonUser");

		String id = logonUser.getId();
		

		String ment = req.getParameter("ment");

        String target = req.getParameter("id");
		Map<String, Object> params = new HashMap<>();

		params.put("moimId", target);
		params.put("writer", id);
		params.put("ment", ment);
		
		 sqlSession.insert("replys.create", params);
//		
//		Reply r = new Reply();
//		r.setMent(ment);
//		r.setWriter(id);
//		r.setMoimId(target);
//		
//		sqlSession.insert("replys.createByVo",r);
//		
		
		sqlSession.commit(); //커밋을 시켜줘야 반영이된다 반드시 들어가야됨
		sqlSession.close();

		resp.sendRedirect("/moim/detail?id=" + target );
		 
	}

}
