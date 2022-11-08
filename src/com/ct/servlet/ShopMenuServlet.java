package com.ct.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShopMenuServlet
 */
@WebServlet("/ShopMenuServlet")
public class ShopMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HashMap<Integer, Integer> hashMap = (HashMap<Integer, Integer>)session.getAttribute("dataBaseCartMap");
		String str = "";
		for(Entry<Integer, Integer> entry : hashMap.entrySet()){
			str += entry.getKey()+"&";
			str += entry.getValue() +"#ytl#";
		}
		System.out.println("str="+str);
		request.setAttribute("shopMenu", str);
		request.getRequestDispatcher("/shoppingcar/shopMenu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
