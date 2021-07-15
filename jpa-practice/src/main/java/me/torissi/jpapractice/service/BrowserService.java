package me.torissi.jpapractice.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.torissi.jpapractice.browser.dto.response.BrowserHistoryLogResponse;
import me.torissi.jpapractice.browser.service.BrowserDomainService;
import me.torissi.jpapractice.common.redis.hash.BrowserStatics;
import me.torissi.jpapractice.common.redis.service.BrowserStaticsRedisService;
import me.torissi.jpapractice.notice.domain.vo.Search;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BrowserService {

  private final BrowserStaticsRedisService redisService;
  private final BrowserDomainService service;

  public ResponseEntity<?> getBrowserStatics(Search search) {
    if (redisService.exists("browserStatics")) {
      return ResponseEntity.ok(redisService.get("browserStatics").getList());
    } else {
      List<BrowserHistoryLogResponse> statics = service.getBrowserStatics(search);
      redisService.create(BrowserStatics.createHashRedis("browserStatics", statics));
      return ResponseEntity.ok(statics);
    }
  }
}
