package me.torissi.jpapractice.notice.domain.entity;

import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "TB_ATTACH")
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = PROTECTED)
public class Attach extends EntityExtension {

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "noticeId")
  private Notice notice;

}
