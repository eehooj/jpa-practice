package me.torissi.jpapractice.notice.domain.service;

import lombok.RequiredArgsConstructor;
import me.torissi.jpapractice.notice.domain.entity.NoticeHitsLog;
import me.torissi.jpapractice.notice.domain.repository.NoticeHitsLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NoticeHitsLogDomainService {

  private final NoticeHitsLogRepository repository;

  public NoticeHitsLog create(NoticeHitsLog noticeHitsLog) {
    return repository.save(noticeHitsLog);
  }

}
