package com.ct.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/AddCartListServlet")
public class AddCartListServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;


    public AddCartListServlet() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        PrintWriter pw = response.getWriter();
        Object obj1 = session.getAttribute("dataBaseCartMap");
        Map<Integer, Integer> dataBaseCartMap1 = new HashMap<>();
        if (obj1 == null) {
            dataBaseCartMap1.put(id, 1);
            session.setAttribute("dataBaseCartMap", dataBaseCartMap1);
            System.out.println("添加成功！");
            pw.println("<script>alert('添加成功！')</script>");
            pw.println("<script>location.href='books.jsp'</script>");
        } else {
            Map<Integer, Integer> dataBaseCartMap = (HashMap<Integer, Integer>) obj1;
            if (!dataBaseCartMap.isEmpty()) {
                if (dataBaseCartMap.containsKey(id)) {
                    int count = dataBaseCartMap.get(id);
                    dataBaseCartMap.put(id, count + 1);
                    session.setAttribute("dataBaseCartMap", dataBaseCartMap);
                    System.out.println("已有的添加成功！");
                    pw.println("<script>alert('添加成功！')</script>");
                    pw.println("<script>location.href='books.jsp'</script>");
                } else {
                    dataBaseCartMap.put(id, 1);
                    session.setAttribute("dataBaseCartMap", dataBaseCartMap);
                    System.out.println("添加成功！");
                    pw.println("<script>alert('添加成功！')</script>");
                    pw.println("<script>location.href='books.jsp'</script>");
                }
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        doGet(request, response);
    }

}
