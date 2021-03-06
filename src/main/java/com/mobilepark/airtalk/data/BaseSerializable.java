package com.mobilepark.airtalk.data;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@MappedSuperclass
public class BaseSerializable implements Serializable {

//    @Type(type = "yes_no")
//    @Column(name="DELETED")
//    private Boolean deleted;

    @Column(name="REG_DATE", columnDefinition = "DATETIME", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    @Column(name="MOD_DATE", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modDate;

    @PrePersist
    public void prePersist() {
        setRegDate(Calendar.getInstance().getTime());
        setModDate(Calendar.getInstance().getTime());
//        if (deleted == null) {
//            deleted = false;
//        }
    }

    @PreUpdate
    public void preUpdate() {
        setModDate(Calendar.getInstance().getTime());
    }

//    public Boolean getDeleted() {
//        return deleted;
//    }
//
//    public void setDeleted(Boolean deleted) {
//        this.deleted = deleted;
//    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

}
