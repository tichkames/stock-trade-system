package com.hackerrank.stocktrade.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Trade {
    @Id
    @GeneratedValue
    private Long id;
    private String type;
    @Embedded
    private User user;
    private String symbol;
    private Integer shares;
    private Float price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp timestamp;
}
