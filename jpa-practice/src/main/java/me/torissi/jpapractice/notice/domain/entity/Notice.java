package me.torissi.jpapractice.notice.domain.entity;

import static lombok.AccessLevel.PROTECTED;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "TB_NOTICE")
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = PROTECTED)
public class Notice extends EntityExtension {

  private String title;

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "notice")
  private Attach attach;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "notice")
  private List<Comment> commentList;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "notice")
  private List<NoticeMapping> noticeMappingList;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "notice")
  private List<NoticeHitsLog> logList;

  private Notice(String title) {
    this.title = title;
  }

  public static Notice createEntity(String title) {
    return new Notice(title);
  }
}
