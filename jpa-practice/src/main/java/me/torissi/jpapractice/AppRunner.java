package me.torissi.jpapractice;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
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
  private NoticeRepository noticeRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
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

        noticeHitsLogDomainService.create(NoticeHitsLog.createEntity(notice, logDate, "America"));
      }

      for (int j = 10; j < 33; j++) {
        LocalDateTime logDate = LocalDate
            .ofEpochDay(ThreadLocalRandom.current().nextLong(start, end))
            .atTime(random.nextInt(24), random.nextInt(60), random.nextInt(60));

        noticeHitsLogDomainService.create(NoticeHitsLog.createEntity(notice, logDate, "Korea"));
      }

      for (int j = 33; j < 60; j++) {
        LocalDateTime logDate = LocalDate
            .ofEpochDay(ThreadLocalRandom.current().nextLong(start, end))
            .atTime(random.nextInt(24), random.nextInt(60), random.nextInt(60));

        noticeHitsLogDomainService.create(NoticeHitsLog.createEntity(notice, logDate, "China"));
      }

      for (int j = 60; j < 100; j++) {
        LocalDateTime logDate = LocalDate
            .ofEpochDay(ThreadLocalRandom.current().nextLong(start, end))
            .atTime(random.nextInt(24), random.nextInt(60), random.nextInt(60));

        noticeHitsLogDomainService.create(NoticeHitsLog.createEntity(notice, logDate, "Japan"));
      }
    }

    for (int i = 0; i < 10; i++) {
      Notice notice = Notice.createEntity("title " + i);

      noticeDomainService.create(notice);

      for (int j = 0; j < 20; j++) {
        LocalDateTime logDate = LocalDate
            .ofEpochDay(ThreadLocalRandom.current().nextLong(start, end))
            .atTime(random.nextInt(24), random.nextInt(60), random.nextInt(60));

        noticeHitsLogDomainService.create(NoticeHitsLog.createEntity(notice, logDate, "America"));
      }

      for (int j = 20; j < 60; j++) {
        LocalDateTime logDate = LocalDate
            .ofEpochDay(ThreadLocalRandom.current().nextLong(start, end))
            .atTime(random.nextInt(24), random.nextInt(60), random.nextInt(60));

        noticeHitsLogDomainService.create(NoticeHitsLog.createEntity(notice, logDate, "Korea"));
      }

      for (int j = 60; j < 80; j++) {
        LocalDateTime logDate = LocalDate
            .ofEpochDay(ThreadLocalRandom.current().nextLong(start, end))
            .atTime(random.nextInt(24), random.nextInt(60), random.nextInt(60));

        noticeHitsLogDomainService.create(NoticeHitsLog.createEntity(notice, logDate, "China"));
      }

      for (int j = 80; j < 100; j++) {
        LocalDateTime logDate = LocalDate
            .ofEpochDay(ThreadLocalRandom.current().nextLong(start, end))
            .atTime(random.nextInt(24), random.nextInt(60), random.nextInt(60));

        noticeHitsLogDomainService.create(NoticeHitsLog.createEntity(notice, logDate, "Japan"));
      }
    }

    Search search = new Search();

    search.setStartDt(LocalDate.of(2021, 6, 1));
    search.setEndDt(LocalDate.of(2021, 6, 30));
    //search.setEndDt(LocalDate.now());
    search.setNation("Korea");

    //List<NoticeAllResponse> list = noticeRepository.getNoticeAll(search);
    List<NoticeAllResponse> list = noticeRepository.getNoticeAllNation(search);
  }
}
