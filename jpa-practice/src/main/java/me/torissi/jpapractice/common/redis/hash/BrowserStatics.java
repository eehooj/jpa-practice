package me.torissi.jpapractice.common.redis.hash;

import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.Getter;
import me.torissi.jpapractice.browser.dto.response.BrowserHistoryLogResponse;
import me.torissi.jpapractice.common.enumerate.BrowserType;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash("browserStatics")
public class BrowserStatics {

  @Id
  private String id;
  private List<BrowserHistoryLogResponse> list;

  private BrowserStatics(String id, List<BrowserHistoryLogResponse> list) {
    this.id = id;
    this.list = list;
  }

  public static BrowserStatics createHashRedis(String id, List<BrowserHistoryLogResponse> list) {
    return new BrowserStatics(id, list);
  }
}
