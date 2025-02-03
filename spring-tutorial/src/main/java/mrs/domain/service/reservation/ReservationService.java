package mrs.domain.service.reservation;

import java.util.List;
import java.util.Objects;

import mrs.domain.model.User;
import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;
import mrs.domain.model.Reservation;
import mrs.domain.model.RoleName;
import mrs.domain.repository.reservation.ReservationRepository;
import mrs.domain.repository.room.ReservableRoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationService {
  @Autowired
  ReservationRepository reservationRepository;

  @Autowired
  ReservableRoomRepository reservableRoomRepository;

  public List<Reservation> findReservatgions(ReservableRoomId reservableRoomId) {
    return reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId);
  }

  public Reservation reserve(Reservation reservation) {
    ReservableRoomId reservableRoomId = reservation.getReservableRoom().getReservableRoomId();

    ReservableRoom reservable = reservableRoomRepository.findOneForUpdateByReservableRoomId(reservableRoomId);
    if (reservable == null) {
      throw new UnavailableReservationException("予約が埋まっています");
    }

    boolean overlap = reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId).stream()
        .anyMatch(x -> x.overlap(reservation));
    if (overlap) {
      throw new AlreadyReservedException("入力の時間帯はすでに予約済みです");
    }

    reservationRepository.save(reservation);
    return reservation;
  }

  public void cancel(Integer reservationId, User requestUser) {
    Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
    if (reservation == null) {
      System.out.println("=== reservation not found ===");
    }

    if (RoleName.ADMIN != requestUser.getRoleName()
        && !Objects.equals(reservation.getUser().getUserId(), requestUser.getUserId())) {
      throw new IllegalStateException("要求されたキャンセルは許可されていません");
    }
    reservationRepository.delete(reservation);
  }
}
