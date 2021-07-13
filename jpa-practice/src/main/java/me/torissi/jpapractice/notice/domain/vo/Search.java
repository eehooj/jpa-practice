package me.torissi.jpapractice.notice.domain.vo;

import java.time.LocalDate;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Search {

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate startDt;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate endDt;

  private String nation;
}
