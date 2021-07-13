package me.torissi.jpapractice.browser.service;

import lombok.RequiredArgsConstructor;
import me.torissi.jpapractice.browser.entity.BrowserHistoryLog;
import me.torissi.jpapractice.browser.repository.BrowserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrowserDomainService {

  private final BrowserRepository repository;

  public BrowserHistoryLog create(BrowserHistoryLog browserHistoryLog) {
    return repository.save(browserHistoryLog);
  }

}
