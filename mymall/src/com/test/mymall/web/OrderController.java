package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.service.ItemService;
import com.test.mymall.vo.Member;
import com.test.mymall.vo.MemberItem;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("OrderController.java - doGet");
		HttpSession session = request.getSession();
		Member member = new Member();
		MemberItem memberItem = new MemberItem();
		ItemService itemService = new ItemService();
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		member = (Member) session.getAttribute("loginMember");
		memberItem.setItem_no(itemNo);
		memberItem.setMember_no(member.getNo());
		itemService.Order(memberItem);
		response.sendRedirect(request.getContextPath() + "/OrderListController");
	}
}
