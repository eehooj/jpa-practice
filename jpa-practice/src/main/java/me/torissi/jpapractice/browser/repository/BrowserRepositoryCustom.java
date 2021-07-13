package me.torissi.jpapractice.browser.repository;

import java.util.List;
import me.torissi.jpapractice.browser.dto.response.BrowserHistoryLogResponse;
import me.torissi.jpapractice.notice.domain.vo.Search;

public interface BrowserRepositoryCustom {

  List<BrowserHistoryLogResponse> getBrowserStatics(Search search);
}
