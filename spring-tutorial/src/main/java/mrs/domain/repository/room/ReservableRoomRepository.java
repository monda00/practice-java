package mrs.domain.repository.room;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;

public interface ReservableRoomRepository extends JpaRepository<ReservableRoom, ReservableRoomId> {
  @Lock(LockModeType.PESSIMISTIC_WRITE)
  ReservableRoom findOneForUpdateByReservableRoomId(ReservableRoomId reservableRoomId);

  List<ReservableRoom> findByReservableRoomId_ReservedDateOrderByReservableRoomId_RoomIdAsc(LocalDate reservedDate);
}