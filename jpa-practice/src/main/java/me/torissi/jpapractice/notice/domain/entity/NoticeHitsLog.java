package me.torissi.jpapractice.notice.domain.entity;

import static lombok.AccessLevel.PROTECTED;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.torissi.jpapractice.common.enumerate.NationType;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "TB_NOTICE_HITS_LOG")
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = PROTECTED)
public class NoticeHitsLog extends EntityExtension {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "noticeId")
  private Notice notice;

  private LocalDateTime logDate;

  private NationType nation;

  private NoticeHitsLog(Notice notice, LocalDateTime logDate, NationType nation) {
    this.notice = notice;
    this.logDate = logDate;
    this.nation = nation;
  }

  public static NoticeHitsLog createEntity(Notice notice, LocalDateTime logDate, NationType nation) {
    return new NoticeHitsLog(notice, logDate, nation);
  }

}
