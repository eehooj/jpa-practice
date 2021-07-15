package me.torissi.jpapractice.common.redis.service;

import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.torissi.jpapractice.common.redis.hash.BrowserStatics;
import me.torissi.jpapractice.common.redis.repository.BrowserStaticsRedisRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BrowserStaticsRedisService {

  private final BrowserStaticsRedisRepository browserStaticsRedisRepository;

  @Transactional
  public BrowserStatics create(BrowserStatics entity) {
    return browserStaticsRedisRepository.save(entity);
  }

  public Boolean exists(String id) {
    return browserStaticsRedisRepository.existsById(id);
  }

  public BrowserStatics get(String id) {
    return browserStaticsRedisRepository
        .findById(id)
        .orElseThrow(EntityNotFoundException::new);
  }

  public BrowserStatics getList(String id) {
    return browserStaticsRedisRepository
        .findById(id)
        .orElseThrow(EntityNotFoundException::new);
  }
}
