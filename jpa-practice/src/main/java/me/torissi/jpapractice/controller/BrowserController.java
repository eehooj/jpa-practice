package me.torissi.jpapractice.controller;

import lombok.RequiredArgsConstructor;
import me.torissi.jpapractice.notice.domain.vo.Search;
import me.torissi.jpapractice.service.BrowserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class BrowserController {

  private final BrowserService browserService;

  @GetMapping("/browser-statics")
  public ResponseEntity<?> getBrowserStatics(@ModelAttribute Search search) {
    return browserService.getBrowserStatics(search);
  }
}
