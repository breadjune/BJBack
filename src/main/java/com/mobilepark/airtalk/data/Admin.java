package com.mobilepark.airtalk.data;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="TBL_ADMIN")
public class Admin extends BaseSerializable {

    private static final long serialVersionUID = -2382480158604649420L;
    
    @Id
    @Column(name="ADMIN_ID")
    private String adminId;

    @Column(name="ADMIN_NAME")
    private String adminName;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="PASSWORD_UPDATE_DATE")
    private Date passwordUpdateDate;

    @Column(name="ADMIN_GROUP_SEQ")
    private int adminGroupSeq;

    @Column(name="PHONE")
    private String phone;

    @Column(name="MCODE")
    private String mcode;

    @Column(name="EMAIL")
    private String email;

    @OneToOne(targetEntity = AdminGroup.class)
    @JoinColumn(name="ADMIN_GROUP_SEQ", insertable = false, updatable = false)
    @NotFound(action=NotFoundAction.IGNORE)
    private AdminGroup adminGroup;

    @Transient
    private String roleName;
}
