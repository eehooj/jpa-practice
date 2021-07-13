package me.torissi.jpapractice.notice.domain.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class NoticeStatisticsNationResponse {

  private String title;

  private double hit;

  private double nationalHit;

  @QueryProjection
  public NoticeStatisticsNationResponse(String title, double hit, double nation) {
    this.title = title;
    this.hit = hit;
    this.nationalHit = nation;
  }
}
