package me.torissi.jpapractice.notice.domain.vo;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Search {

  private LocalDate startDt;

  private LocalDate endDt;
}
