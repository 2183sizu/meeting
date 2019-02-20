package Servlect;

import dao.MeetingRoomDao;
import entity.MeetingRoom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

/**
 * Created by 钟家龙 on 2019-01-15.
 */
@WebServlet(name = "addServlet",urlPatterns = "/add")
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        MeetingRoomDao meetingRoomDao=new MeetingRoomDao();
        MeetingRoom meetingRoom=new MeetingRoom();
        response.setContentType("text/html;charset=utf-8");
        String type=request.getParameter("type");
        PrintWriter out= response.getWriter();
        meetingRoom.setMeeting_name(request.getParameter("xiala"));
        meetingRoom.setMeeting_order(Date.valueOf(request.getParameter("riqi")));
        meetingRoom.setAdvance_name(request.getParameter("shen"));
        int x=meetingRoomDao.add(meetingRoom);
        if(x==1){
            out.print("<script type=\"text/javascript\">alert(\"添加成功\");window.location.href='sel'</script>");
            out.flush();
            out.close();

        }else{
            response.sendRedirect("add.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
