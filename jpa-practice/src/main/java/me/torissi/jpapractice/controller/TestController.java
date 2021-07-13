package me.torissi.jpapractice.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.torissi.jpapractice.browser.dto.response.BrowserHistoryLogResponse;
import me.torissi.jpapractice.browser.repository.BrowserRepository;
import me.torissi.jpapractice.notice.domain.repository.NoticeRepository;
import me.torissi.jpapractice.notice.domain.vo.Search;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

  private final NoticeRepository noticeRepository;

  private final BrowserRepository browserRepository;

  @GetMapping("test")
  public void test(@ModelAttribute Search search) {
    noticeRepository.getNoticeAllNation(search);
  }

  @GetMapping("/browser-statics")
  public List<BrowserHistoryLogResponse> browserStatics(@ModelAttribute Search search) {
    return browserRepository.getBrowserStatics(search);
  }
}
