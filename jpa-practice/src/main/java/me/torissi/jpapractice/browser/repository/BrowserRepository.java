package me.torissi.jpapractice.browser.repository;

import me.torissi.jpapractice.browser.entity.BrowserHistoryLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrowserRepository extends JpaRepository<BrowserHistoryLog, Long>, BrowserRepositoryCustom {

}
