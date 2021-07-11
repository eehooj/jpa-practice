package me.torissi.jpapractice.notice.domain.repository;

import java.util.List;
import me.torissi.jpapractice.notice.domain.dto.response.NoticeAllResponse;
import me.torissi.jpapractice.notice.domain.vo.Search;

public interface NoticeRepositoryCustom {

  List<NoticeAllResponse> getNoticeAll(Search search);
}
