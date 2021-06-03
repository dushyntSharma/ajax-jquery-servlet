package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class FormData
 */
public class FormData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String data = request.getParameter("data");
		System.out.println(data);
		JSONParser parser = new JSONParser();
		JSONObject jobj = null;
		try {
			jobj = (JSONObject) parser.parse(data);
			String email = (String) jobj.get("email");
			String pass = (String) jobj.get("password");
			System.out.println(email + " " + pass);

			HttpSession session = request.getSession();
			if (email.equals("shree@gmail.com") && pass.equals("shree")) {
				session.setAttribute("email", email);
				session.setAttribute("password", pass);
				System.out.println("redirect properly");
				response.getWriter().write("welcome.jsp");

			} else {
				System.out.println("not redirect properly");
				response.getWriter().write("home.jsp");

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
