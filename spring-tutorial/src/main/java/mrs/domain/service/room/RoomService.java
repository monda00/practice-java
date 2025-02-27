package mrs.domain.service.room;

import java.time.LocalDate;
import java.util.List;

import mrs.domain.model.ReservableRoom;
import mrs.domain.model.MeetingRoom;
import mrs.domain.repository.room.ReservableRoomRepository;
import mrs.domain.repository.room.MeetingRoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomService {

  @Autowired
  ReservableRoomRepository reservableRoomRepository;

  @Autowired
  MeetingRoomRepository meetingRoomRepository;

  public List<ReservableRoom> findReservableRooms(LocalDate date) {
    return reservableRoomRepository.findByReservableRoomId_ReservedDateOrderByReservableRoomId_RoomIdAsc(date);
  }

  public MeetingRoom findMeetingRoom(Integer roomId) {
    MeetingRoom meetingRoom = meetingRoomRepository.findById(roomId).orElse(null);
    if (meetingRoom == null) {
      System.out.println("=== meeting room not found ===");
    }
    return meetingRoom;
  }
}
