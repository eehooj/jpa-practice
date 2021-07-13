package me.torissi.jpapractice.controller;

import lombok.RequiredArgsConstructor;
import me.torissi.jpapractice.notice.domain.repository.NoticeRepository;
import me.torissi.jpapractice.notice.domain.vo.Search;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

  private final NoticeRepository noticeRepository;

  @GetMapping("test")
  public void test(@ModelAttribute Search search) {
    noticeRepository.getNoticeAllNation(search);
  }

}
