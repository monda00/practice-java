package mrs.domain.model;

import java.io.Serializable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservable_room")
public class ReservableRoom implements Serializable {
  @EmbeddedId
  private ReservableRoomId reservableRoomId;

  @ManyToOne
  @JoinColumn(name = "room_id", insertable = false, updatable = false)
  @MapsId("roomId")
  private MeetingRoom meetingRoom;

  public ReservableRoom(ReservableRoomId reservableRoomId) {
    this.reservableRoomId = reservableRoomId;
  }

  public ReservableRoom() {
  }

  // getter, setter

  public ReservableRoomId getReservableRoomId() {
    return reservableRoomId;
  }

  public void setReservableRoomId(ReservableRoomId reservableRoomId) {
    this.reservableRoomId = reservableRoomId;
  }

  public MeetingRoom getMeetingRoom() {
    return meetingRoom;
  }

  public void setMeetingRoom(MeetingRoom meetingRoom) {
    this.meetingRoom = meetingRoom;
  }
}
