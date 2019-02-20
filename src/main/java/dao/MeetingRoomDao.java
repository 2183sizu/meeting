package dao;

import entity.MeetingRoom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 钟家龙 on 2019-01-15.
 */
public class MeetingRoomDao extends BaseDao {
   public List<MeetingRoom> selectall(){
       List<MeetingRoom> list=new ArrayList<>();
        String sql="select id,meeting_name,meeting_order,advance_name from meetingroom ORDER BY meeting_order desc";
        getConn();
       try {
           pata=conn.prepareStatement(sql);
           rs=pata.executeQuery();

           while (rs.next()){
               MeetingRoom meetingRoom=new MeetingRoom();
               meetingRoom.setId(rs.getInt("id"));
               meetingRoom.setMeeting_name(rs.getString("meeting_name"));
               meetingRoom.setAdvance_name(rs.getString("advance_name"));
               meetingRoom.setMeeting_order(rs.getDate("meeting_order"));
               list.add(meetingRoom);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
            return list;
   }
   public int add(MeetingRoom meetingRoom){
       String sql="insert into meetingroom(meeting_name,meeting_order,advance_name)values(?,?,?)";
       Object[] objs={
               meetingRoom.getMeeting_name(),
               meetingRoom.getMeeting_order(),
               meetingRoom.getAdvance_name()
       };
       return executeUpdate(sql,objs);
   }
}
