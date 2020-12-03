package com.aviator.jsonplaceholderendpoints.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
public class Address implements Serializable {

    @Column
    private String street;
    @Column
    private String suite;
    @Column
    private String city;
    @Column
    private String zipcode;
    @Embedded
    private Geo geo;

}
