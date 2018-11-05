package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginController.java - doGet");
		if (request.getSession().getAttribute("loginMember") == null) {
			System.out.println("login.jsp forward.... LoginController.java");
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		} else {
			System.out.println("login.jsp Redirect.... LoginController.java");
			response.sendRedirect("/IndexController");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginController.java - doPost");
		MemberService memberService = new MemberService();
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		Member loginMember = memberService.login(member);
		if (loginMember != null) {
			System.out.println("LoginController.java - LoginSuccess");
			System.out.println(loginMember.getId() + "→ ID LoginController.java");
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		} else if (loginMember == null) {
			System.out.println("LoginController.java - LoginFail");
			response.sendRedirect(request.getContextPath() + "/LoginController");
		}
	}
}
