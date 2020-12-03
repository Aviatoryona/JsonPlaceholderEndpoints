package com.aviator.jsonplaceholderendpoints.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
public class Geo implements Serializable {

    @Column
    private BigDecimal lat;

    @Column
    private BigDecimal lng;

}
