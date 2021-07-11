package me.torissi.jpapractice.notice.domain.repository;

import me.torissi.jpapractice.notice.domain.entity.NoticeHitsLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeHitsLogRepository extends JpaRepository<NoticeHitsLog, Long> {

}
