package me.torissi.jpapractice.notice.domain.entity;

import static lombok.AccessLevel.PROTECTED;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "TB_SCHOOL")
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = PROTECTED)
public class School extends EntityExtension {

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "school")
  private List<NoticeMapping> noticeMappingList;

}
