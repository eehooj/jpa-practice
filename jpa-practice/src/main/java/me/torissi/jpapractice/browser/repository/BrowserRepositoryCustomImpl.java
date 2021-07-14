package me.torissi.jpapractice.browser.repository;


import static me.torissi.jpapractice.browser.entity.QBrowserHistoryLog.browserHistoryLog;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQueryFactory;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import lombok.RequiredArgsConstructor;
import me.torissi.jpapractice.browser.dto.response.BrowserHistoryLogResponse;
import me.torissi.jpapractice.browser.dto.response.QBrowserHistoryLogResponse;
import me.torissi.jpapractice.browser.entity.QBrowserHistoryLog;
import me.torissi.jpapractice.notice.domain.vo.Search;

@RequiredArgsConstructor
public class BrowserRepositoryCustomImpl implements BrowserRepositoryCustom {

  private final JPQLQueryFactory queryFactory;

  @Override
  public List<BrowserHistoryLogResponse> getBrowserStatics(Search search) {
    QBrowserHistoryLog browserHistoryLogSub = new QBrowserHistoryLog("browserHistoryLogSub"); // 올ㅋ
    QBrowserHistoryLog browserHistoryLogSub2 = new QBrowserHistoryLog("browserHistoryLogSub2");

    LocalDate firstDay = search.getSdt().withDayOfMonth(1);
    LocalDate lastDay = search.getEdt().withDayOfMonth(search.getEdt().lengthOfMonth());

    List<BrowserHistoryLogResponse> statics = queryFactory
        .select(new QBrowserHistoryLogResponse(
            browserHistoryLog.year,
            browserHistoryLog.month,
            browserHistoryLog.type,
            JPAExpressions
                .select(
                    browserHistoryLogSub.count().castToNum(Double.class)
                    .divide(
                        JPAExpressions
                            .select(browserHistoryLogSub2.count())
                            .from(browserHistoryLogSub2)
                            .where(
                                browserHistoryLogSub2.nation.eq(search.getNation()),
                                browserHistoryLogSub2.year.eq(browserHistoryLogSub.year),
                                browserHistoryLogSub2.month.eq(browserHistoryLogSub.month)
                            )
                    )
                    .multiply(100)
                )
                .from(browserHistoryLogSub)
                .where(
                    browserHistoryLogSub.nation.eq(search.getNation()),
                    browserHistoryLogSub.year.eq(browserHistoryLog.year),
                    browserHistoryLogSub.month.eq(browserHistoryLog.month)
                )
                .groupBy(browserHistoryLogSub.type)
                .having(
                    browserHistoryLogSub.type.eq(browserHistoryLog.type)
                )
        ))
        .from(browserHistoryLog)
        .where(
            browserHistoryLog.delFlag.isFalse(),
            browserHistoryLog.useFlag.isTrue(),
            browserHistoryLog.logDate.goe(firstDay),
            browserHistoryLog.logDate.loe(lastDay),
            browserHistoryLog.nation.eq(search.getNation())
            )
        .orderBy(
            browserHistoryLog.year.asc(),
            browserHistoryLog.month.asc(),
            browserHistoryLog.type.asc()// type 정렬 추가
        )
        .distinct() // 올ㅋ
        .fetch();

    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    statics.forEach(item -> System.out.println(
        "year : " + item.getYear() + ", month : " + item.getMonth()
            + ", type : " + item.getType() + ", percent : " + item.getPercent()
    ));
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

    return statics;
  }
}
