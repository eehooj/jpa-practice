package me.torissi.jpapractice.notice.domain.vo;

import java.time.LocalDate;
import lombok.Data;
import me.torissi.jpapractice.common.enumerate.BrowserType;
import me.torissi.jpapractice.common.enumerate.NationType;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Search {

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate sdt;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate edt;

  private NationType nation;
}
