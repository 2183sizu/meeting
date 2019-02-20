package Servlect;

import com.alibaba.fastjson.JSON;
import dao.MeetingRoomDao;
import entity.MeetingRoom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by 钟家龙 on 2019-01-15.
 */
@WebServlet(name = "selectServlet",urlPatterns = "/select")
public class selectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MeetingRoomDao meetingRoomDao=new MeetingRoomDao();
        MeetingRoom meetingRoom=new MeetingRoom();
        List<MeetingRoom> list=meetingRoomDao.selectall();
        request.getSession().setAttribute("list",list);
        //response.sendRedirect("index.jsp");
        PrintWriter out=response.getWriter();
        String str= JSON.toJSONString(list);
        //System.out.println(str);
        out.print(str);
        out.flush();
        out.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
