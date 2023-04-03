package controller.moim;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Moim;
import data.User;
import repository.Moims;

@WebServlet("/moim/join")
public class MoimJoinController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String moimId = req.getParameter("moimId");
		User user = (User) req.getSession().getAttribute("logonUser");
		String userId = user.getId();
		Moim moim = Moims.findById(moimId);
		int cp = moim.getCurrentPerson();
		int mp = moim.getMaxPerson();
		String type =moim.getType();
		int status = 0;
		if(type.equals("public") && cp <= mp) {
			
			
			
			
		}
		

	}
}
