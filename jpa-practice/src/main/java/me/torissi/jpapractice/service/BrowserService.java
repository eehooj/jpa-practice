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
      BrowserStatics browserStatics = redisService.get("browserStatics");

      if (browserStatics.getStartDate().equals(search.getSdt())
          && browserStatics.getEndDate().equals(search.getEdt())
          && browserStatics.getNation().equals(search.getNation())) {
        return ResponseEntity.ok(browserStatics.getList());
      }
    }
    return getBrowserStaticsListResponse(search);
  }

  private ResponseEntity<?> getBrowserStaticsListResponse(Search search) {
    List<BrowserHistoryLogResponse> statics = service.getBrowserStatics(search);
    redisService.create(BrowserStatics
        .createHashRedis(
            "browserStatics",
            statics,
            search.getSdt(),
            search.getEdt(),
            search.getNation()
        )
    );
    return ResponseEntity.ok(statics);
  }
}
