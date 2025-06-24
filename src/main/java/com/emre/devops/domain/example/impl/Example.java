package com.emre.devops.domain.example.impl;

import com.emre.devops.core.rest.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = Example.TABLE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Example extends AbstractEntity {
    public static final String TABLE = "example";
    private static final String COL_NAME = "name";

    @Column(name = COL_NAME)
    private String name;


}
    