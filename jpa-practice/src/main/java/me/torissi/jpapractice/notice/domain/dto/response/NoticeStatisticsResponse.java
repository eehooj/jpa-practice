package me.torissi.jpapractice.notice.domain.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class NoticeStatisticsResponse {

  private String title;

  private double hit;

  @QueryProjection
  public NoticeStatisticsResponse(String title, double hit) {
    this.title = title;
    this.hit = hit;
  }
}
