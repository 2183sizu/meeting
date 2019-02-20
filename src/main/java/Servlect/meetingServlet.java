package Servlect;

import dao.MeetingRoomDao;
import entity.MeetingRoom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 钟家龙 on 2019-01-15.
 */
@WebServlet(name = "meetingServlet",urlPatterns = "/sel")
public class meetingServlet extends HttpServlet {
    MeetingRoomDao meetingRoomDao=new MeetingRoomDao();
    MeetingRoom meetingRoom=new MeetingRoom();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type=request.getParameter("type");
        List<MeetingRoom> list=meetingRoomDao.selectall();
        request.getSession().setAttribute("list",list);
        response.sendRedirect("index.jsp");

    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
