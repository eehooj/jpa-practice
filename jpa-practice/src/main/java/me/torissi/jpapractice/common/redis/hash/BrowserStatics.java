package me.torissi.jpapractice.common.redis.hash;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.Getter;
import me.torissi.jpapractice.browser.dto.response.BrowserHistoryLogResponse;
import me.torissi.jpapractice.common.enumerate.BrowserType;
import me.torissi.jpapractice.common.enumerate.NationType;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash("browserStatics")
public class BrowserStatics {

  @Id
  private String id;
  private List<BrowserHistoryLogResponse> list;
  private LocalDate startDate;
  private LocalDate endDate;
  @Enumerated(EnumType.STRING)
  private NationType nation;

  public BrowserStatics(String id, List<BrowserHistoryLogResponse> list,
      LocalDate startDate, LocalDate endDate, NationType nation) {
    this.id = id;
    this.list = list;
    this.startDate = startDate;
    this.endDate = endDate;
    this.nation = nation;
  }

  public static BrowserStatics createHashRedis(String id, List<BrowserHistoryLogResponse> list,
      LocalDate startDate, LocalDate endDate, NationType nation) {
    return new BrowserStatics(id, list, startDate, endDate, nation);
  }
}
