package me.torissi.jpapractice.notice.domain.service;

import lombok.RequiredArgsConstructor;
import me.torissi.jpapractice.notice.domain.entity.Notice;
import me.torissi.jpapractice.notice.domain.repository.NoticeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NoticeDomainService {

  private final NoticeRepository repository;

  public Notice create(Notice notice) {
    return repository.save(notice);
  }

}
