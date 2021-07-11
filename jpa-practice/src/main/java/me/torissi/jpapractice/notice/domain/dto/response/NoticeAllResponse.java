package me.torissi.jpapractice.notice.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeAllResponse {

  private String title;

  private double averageHits;

  public NoticeAllResponse(String title, double averageHits) {
    this.title = title;
    this.averageHits = averageHits;
  }
}
