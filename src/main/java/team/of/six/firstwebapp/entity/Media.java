package team.of.six.firstwebapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import liquibase.datatype.core.BlobType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.jdbc.BlobImplementer;
import org.hibernate.type.descriptor.java.BlobJavaType;
import org.hibernate.type.descriptor.jdbc.BlobJdbcType;

import java.sql.Blob;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Media
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Lob
  @Column
  private Blob value;
}
