// package io.actbase.testdb.common.infra.jpa.domain;

// import lombok.AllArgsConstructor;
// import lombok.EqualsAndHashCode;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.experimental.SuperBuilder;
// import org.springframework.data.annotation.CreatedDate;
// import org.springframework.data.annotation.LastModifiedDate;
// import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// import javax.persistence.*;
// import java.io.Serializable;
// import java.time.LocalDateTime;

// @Getter
// @NoArgsConstructor
// @AllArgsConstructor
// @SuperBuilder
// @MappedSuperclass
// @EntityListeners(AuditingEntityListener.class)
// @EqualsAndHashCode(onlyExplicitlyIncluded = true)
// public abstract class BaseEntity implements Serializable {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(unique = true, nullable = false)
//     private Long id;

//     @CreatedDate
//     @Column(name = "created_at")
//     private LocalDateTime createdAt;

//     @LastModifiedDate
//     @Column(name = "updated_on")
//     private LocalDateTime updatedOn;

// }

