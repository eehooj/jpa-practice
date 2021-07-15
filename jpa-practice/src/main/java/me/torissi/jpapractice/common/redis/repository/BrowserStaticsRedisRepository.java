package me.torissi.jpapractice.common.redis.repository;

import me.torissi.jpapractice.common.redis.hash.BrowserStatics;
import org.springframework.data.repository.CrudRepository;

public interface BrowserStaticsRedisRepository extends CrudRepository<BrowserStatics, String> {

}
