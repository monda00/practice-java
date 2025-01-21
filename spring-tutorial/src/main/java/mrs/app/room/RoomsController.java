package mrs.app.room;

import java.time.LocalDate;
import java.util.List;

import mrs.domain.model.ReservableRoom;
import mrs.domain.service.room.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("rooms")
public class RoomsController {
  @Autowired
  RoomService roomService;

  @GetMapping
  String listRooms(Model model) {
    LocalDate today = LocalDate.now();
    System.out.println("today: " + today);
    List<ReservableRoom> rooms = roomService.findReservableRooms(today);
    for (ReservableRoom room : rooms) {
      System.out.println("room: " + room.getReservableRoomId());
    }
    model.addAttribute("date", today);
    model.addAttribute("rooms", rooms);
    return "room/listRooms";
  }

  @GetMapping("{date}")
  String listRooms(
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date, Model model) {
      System.out.println("date: " + date);
      List<ReservableRoom> rooms = roomService.findReservableRooms(date);
      for (ReservableRoom room : rooms) {
        System.out.println("room: " + room.getReservableRoomId());
      }
      model.addAttribute("date", date);
      model.addAttribute("rooms", rooms);
      return "room/listRooms";
    }
}