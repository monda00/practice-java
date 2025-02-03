package mrs.app.reservation;

import java.io.Serializable;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@EndTimeMustBeAfterStartTime(message = "The end time must be after the start time")
public class ReservationForm implements Serializable {
  @NotNull(message = "This field is required")
  @ThirtyMinutesUnit(message = "Please enter a time with 30-minute units")
  @DateTimeFormat(pattern = "HH:mm")
  private LocalTime startTime;

  @NotNull(message = "This field is required")
  @ThirtyMinutesUnit(message = "Please enter a time with 30-minute units")
  @DateTimeFormat(pattern = "HH:mm")
  private LocalTime endTime;

  public LocalTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalTime startTime) {
    this.startTime = startTime;
  }

  public LocalTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalTime endTime) {
    this.endTime = endTime;
  }
}
