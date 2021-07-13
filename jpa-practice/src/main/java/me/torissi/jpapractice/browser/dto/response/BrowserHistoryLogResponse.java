package me.torissi.jpapractice.browser.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import me.torissi.jpapractice.common.enumerate.BrowserType;

@Getter
public class BrowserHistoryLogResponse {

  private Integer year;

  private Integer month;

  private BrowserType type;

  private Double percent;

  @QueryProjection
  public BrowserHistoryLogResponse(Integer year, Integer month, BrowserType type, Double percent) {
    this.year = year;
    this.month = month;
    this.type = type;
    this.percent = percent;
  }
}
