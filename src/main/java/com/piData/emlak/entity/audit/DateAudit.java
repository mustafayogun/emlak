package com.piData.emlak.entity.audit;


import com.piData.emlak.core.domain.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createAt","updateAt"},
        allowGetters = true
)
public abstract class DateAudit extends BaseModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    private Long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    @Setter
    @Getter
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    @Setter
    @Getter
    private Instant updatedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC+3"))).toInstant();
        this.updatedAt = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC+3"))).toInstant();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC+3"))).toInstant();
    }

}
