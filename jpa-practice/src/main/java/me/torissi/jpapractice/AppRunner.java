package me.torissi.jpapractice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import me.torissi.jpapractice.browser.entity.BrowserHistoryLog;
import me.torissi.jpapractice.browser.repository.BrowserRepository;
import me.torissi.jpapractice.browser.service.BrowserDomainService;
import me.torissi.jpapractice.common.enumerate.BrowserType;
import me.torissi.jpapractice.common.enumerate.NationType;
import me.torissi.jpapractice.notice.domain.dto.response.NoticeAllResponse;
import me.torissi.jpapractice.notice.domain.entity.Notice;
import me.torissi.jpapractice.notice.domain.entity.NoticeHitsLog;
import me.torissi.jpapractice.notice.domain.repository.NoticeRepository;
import me.torissi.jpapractice.notice.domain.service.NoticeDomainService;
import me.torissi.jpapractice.notice.domain.service.NoticeHitsLogDomainService;
import me.torissi.jpapractice.notice.domain.vo.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

  @Autowired
  private NoticeDomainService noticeDomainService;

  @Autowired
  private NoticeHitsLogDomainService noticeHitsLogDomainService;

  @Autowired
  private BrowserDomainService browserDomainService;

  @Autowired
  private NoticeRepository noticeRepository;

  @Autowired
  private BrowserRepository browserRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    //noticeCreate();
    browserLogCreate();
  }

  private void browserLogCreate() {

    for (int i = 0; i < 1000; i++) {
      LocalDate logDate = getRandomLocalDate();
      BrowserType[] browserTypes = BrowserType.values();
      NationType[] nationTypes = NationType.values();
      Random random = new Random();
      int browserRandom = random.nextInt(6);
      int nationRandom = random.nextInt(4);

      BrowserHistoryLog browserLog = BrowserHistoryLog.createEntity(
          browserTypes[browserRandom],
          nationTypes[nationRandom],
          logDate.getYear(),
          logDate.getMonthValue(),
          logDate
      );

      browserDomainService.create(browserLog);
    }

    Search search = new Search();

    search.setSdt(LocalDate.of(2021, 2, 1));
    search.setEdt(LocalDate.of(2021, 6, 30));
    search.setNation(NationType.KOREA);

    browserRepository.getBrowserStatics(search);

  }

  private LocalDate getRandomLocalDate() {
    Random random = new Random();
    long start = LocalDate.of(2020, 1, 1).toEpochDay();
    long end = LocalDate.now().toEpochDay();

    LocalDate logDate = LocalDate
        .ofEpochDay(ThreadLocalRandom.current().nextLong(start, end));
    return logDate;
  }

  private void noticeCreate() {
    Random random = new Random();
    long start = LocalDate.of(2020, 1, 1).toEpochDay();
    long end = LocalDate.now().toEpochDay();

    for (int i = 10; i < 15; i++) {
      Notice notice = Notice.createEntity("title " + i);

      noticeDomainService.create(notice);

      for (int j = 0; j < 10; j++) {
        LocalDateTime logDate = LocalDate
            .ofEpochDay(ThreadLocalRandom.current().nextLong(start, end))
            .atTime(random.nextInt(24), random.nextInt(60), random.nextInt(60));

        noticeHitsLogDomainService.create(NoticeHitsLog.createEntity(notice, logDate, NationType.AMERICA));
      }

      for (int j = 10; j < 33; j++) {
        LocalDateTime logDate = LocalDate
            .ofEpochDay(ThreadLocalRandom.current().nextLong(start, end))
            .atTime(random.nextInt(24), random.nextInt(60), random.nextInt(60));

        noticeHitsLogDomainService.create(NoticeHitsLog.createEntity(notice, logDate, NationType.KOREA));
      }

      for (int j = 33; j < 60; j++) {
        LocalDateTime logDate = LocalDate
            .ofEpochDay(ThreadLocalRandom.current().nextLong(start, end))
            .atTime(random.nextInt(24), random.nextInt(60), random.nextInt(60));

        noticeHitsLogDomainService.create(NoticeHitsLog.createEntity(notice, logDate, NationType.CHINA));
      }

      for (int j = 60; j < 100; j++) {
        LocalDateTime logDate = LocalDate
            .ofEpochDay(ThreadLocalRandom.current().nextLong(start, end))
            .atTime(random.nextInt(24), random.nextInt(60), random.nextInt(60));

        noticeHitsLogDomainService.create(NoticeHitsLog.createEntity(notice, logDate, NationType.JAPAN));
      }
    }

    for (int i = 0; i < 10; i++) {
      Notice notice = Notice.createEntity("title " + i);

      noticeDomainService.create(notice);

      for (int j = 0; j < 20; j++) {
        LocalDateTime logDate = LocalDate
            .ofEpochDay(ThreadLocalRandom.current().nextLong(start, end))
            .atTime(random.nextInt(24), random.nextInt(60), random.nextInt(60));

        noticeHitsLogDomainService.create(NoticeHitsLog.createEntity(notice, logDate, NationType.AMERICA));
      }

      for (int j = 20; j < 60; j++) {
        LocalDateTime logDate = LocalDate
            .ofEpochDay(ThreadLocalRandom.current().nextLong(start, end))
            .atTime(random.nextInt(24), random.nextInt(60), random.nextInt(60));

        noticeHitsLogDomainService.create(NoticeHitsLog.createEntity(notice, logDate, NationType.KOREA));
      }

      for (int j = 60; j < 80; j++) {
        LocalDateTime logDate = LocalDate
            .ofEpochDay(ThreadLocalRandom.current().nextLong(start, end))
            .atTime(random.nextInt(24), random.nextInt(60), random.nextInt(60));

        noticeHitsLogDomainService.create(NoticeHitsLog.createEntity(notice, logDate, NationType.CHINA));
      }

      for (int j = 80; j < 100; j++) {
        LocalDateTime logDate = LocalDate
            .ofEpochDay(ThreadLocalRandom.current().nextLong(start, end))
            .atTime(random.nextInt(24), random.nextInt(60), random.nextInt(60));

        noticeHitsLogDomainService.create(NoticeHitsLog.createEntity(notice, logDate, NationType.JAPAN));
      }
    }

    Search search = new Search();

    search.setSdt(LocalDate.of(2021, 6, 1));
    search.setEdt(LocalDate.of(2021, 6, 30));
    //search.setEndDt(LocalDate.now());
    search.setNation(NationType.KOREA);

    //List<NoticeAllResponse> list = noticeRepository.getNoticeAll(search);
    List<NoticeAllResponse> list = noticeRepository.getNoticeAllNation(search);
  }
}
