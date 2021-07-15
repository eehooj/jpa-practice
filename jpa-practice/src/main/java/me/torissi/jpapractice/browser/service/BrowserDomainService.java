package me.torissi.jpapractice.browser.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.torissi.jpapractice.browser.dto.response.BrowserHistoryLogResponse;
import me.torissi.jpapractice.browser.entity.BrowserHistoryLog;
import me.torissi.jpapractice.browser.repository.BrowserRepository;
import me.torissi.jpapractice.notice.domain.vo.Search;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrowserDomainService {

  private final BrowserRepository repository;

  public BrowserHistoryLog create(BrowserHistoryLog browserHistoryLog) {
    return repository.save(browserHistoryLog);
  }

  public List<BrowserHistoryLogResponse> getBrowserStatics(Search search) {
    return repository.getBrowserStatics(search);
  }
}
