package com.emre.devops.core.rest;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = "id")
@ToString(onlyExplicitlyIncluded = true)
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    @ToString.Include
    private UUID id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime created;

    @LastModifiedDate
    @Column
    private LocalDateTime modified;

    @Column(nullable = false)
    private boolean deleted = false;

}
