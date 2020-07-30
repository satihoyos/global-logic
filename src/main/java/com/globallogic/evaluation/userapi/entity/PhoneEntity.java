package com.globallogic.evaluation.userapi.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sati on 29-07-20.
 */
@Entity
@Table(name = "phone")
public class PhoneEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String number;
    @Column(name="city_code")
    private String cityCode;
    @Column(name="contry_code")
    private String contryCode;
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date create;
    @Column(name = "modified_at")
    @Temporal(TemporalType.DATE)
    private Date  modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getContryCode() {
        return contryCode;
    }

    public void setContryCode(String contryCode) {
        this.contryCode = contryCode;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "PhoneEntity{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", contryCode='" + contryCode + '\'' +
                ", create=" + create +
                ", modified=" + modified +
                '}';
    }
}
