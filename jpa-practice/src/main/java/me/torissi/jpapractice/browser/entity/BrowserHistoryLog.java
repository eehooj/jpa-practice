package me.torissi.jpapractice.browser.entity;

import static lombok.AccessLevel.PROTECTED;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.torissi.jpapractice.common.enumerate.BrowserType;
import me.torissi.jpapractice.common.enumerate.NationType;
import me.torissi.jpapractice.notice.domain.entity.EntityExtension;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "TB_BROWSER_HISTORY_LOG")
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = PROTECTED)
public class BrowserHistoryLog extends EntityExtension {

  @Enumerated(EnumType.STRING)
  private BrowserType type;

  @Enumerated(EnumType.STRING)
  private NationType nation;

  private Integer year;

  private Integer month;

  private LocalDate logDate;

  private BrowserHistoryLog(BrowserType type,
      NationType nation, Integer year, Integer month, LocalDate logDate) {
    this.type = type;
    this.nation = nation;
    this.year = year;
    this.month = month;
    this.logDate = logDate;
  }

  public static BrowserHistoryLog createEntity(BrowserType type,
      NationType nation, Integer year, Integer month, LocalDate logDate) {
    return new BrowserHistoryLog(type, nation, year, month, logDate);
  }
}
