package me.torissi.jpapractice.notice.domain.repository;

import me.torissi.jpapractice.notice.domain.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long>, NoticeRepositoryCustom {

}
