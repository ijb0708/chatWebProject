package com.jb.minetownapi.mapper;

import com.jb.minetownapi.dto.Room;

import java.util.Date;
import java.util.List;

public interface RoomMapper {
    
    int insertRoom(Room room);
    
    List<Room> selectRoomList(Date startDate, Date endDate);
    
    Room selectOneRoom(String roomId);
    
}
