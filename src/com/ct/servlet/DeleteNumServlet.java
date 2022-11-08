package com.ct.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DeleteNumServlet")
public class DeleteNumServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public DeleteNumServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        PrintWriter pw = response.getWriter();
        HashMap<Integer, Integer> dataBaseCartMap = (HashMap<Integer, Integer>) session.getAttribute("dataBaseCartMap");
        dataBaseCartMap.remove(id);
        session.setAttribute("dataBaseCartMap", dataBaseCartMap);
        pw.println("<script>alert('修改成功！')</script>");
        pw.println("<script>location.href='shopMenu.jsp'</script>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
