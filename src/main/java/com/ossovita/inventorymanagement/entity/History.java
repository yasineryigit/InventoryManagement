package com.ossovita.inventorymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "history")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class History {

    @Id
    @SequenceGenerator(name = "history_seq", allocationSize = 1)
    @GeneratedValue(generator = "history_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "history_id")
    private long historyId;

    @Column(name = "operation")
    private String operation;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "date_time")
    private LocalDateTime dateTime;


}

