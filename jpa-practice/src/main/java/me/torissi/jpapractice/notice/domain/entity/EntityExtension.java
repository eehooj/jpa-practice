package me.torissi.jpapractice.notice.domain.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@MappedSuperclass
public class EntityExtension {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  protected Long id;

  @ColumnDefault("true")
  protected Boolean useFlag;

  @ColumnDefault("false")
  protected Boolean delFlag;

  @ColumnDefault("CURRENT_TIMESTAMP")
  protected LocalDateTime createDt;

  @ColumnDefault("CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
  protected LocalDateTime updateDt;

}
