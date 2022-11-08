package com.ct.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AddNumServlet")
public class AddNumServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;


    public AddNumServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int count = Integer.parseInt(request.getParameter("count"));
        System.out.println("count=" + count);
        HttpSession session = request.getSession();
        PrintWriter pw = response.getWriter();
        HashMap<Integer, Integer> dataBaseCartMap = (HashMap<Integer, Integer>) session.getAttribute("dataBaseCartMap");
        dataBaseCartMap.put(id, count);
        session.setAttribute("dataBaseCartMap", dataBaseCartMap);
        pw.println("<script>alert('修改成功！')</script>");
        pw.println("<script>location.href='shopMenu.jsp'</script>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
