package com.mo1451.boot.mybatis.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.thymeleaf.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name="sys_role_b")
public class Role implements Serializable {
    @Id
    @Column
    @GeneratedValue(
            generator = "IDENTITY"
    )
    private Long roleId;
    @Column
    @NotEmpty
    @Length(
            max = 40
    )
    @OrderBy("ASC")
    private String roleCode;
    @Column
    @NotEmpty
    @Length(
            max = 150
    )
    private String roleName;
    @Column
    @Length(
            max = 240
    )
    private String roleDescription;
    @Column
    private Date startActiveDate;
    @Column
    private Date endActiveDate;
    @Column
    private String enableFlag;

    public Role() {
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return this.roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = StringUtils.trim(roleCode);
    }

    public String getRoleName() {
        return this.roleName;
    }

    public boolean isEnabled() {
        return "Y".equals(this.enableFlag);
    }

    public boolean isActive() {
        return (this.startActiveDate == null || this.startActiveDate.getTime() <= System.currentTimeMillis()) && (this.endActiveDate == null || this.endActiveDate.getTime() >= System.currentTimeMillis());
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return this.roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public static String getFIELD_ROLE_ID() {
        return "roleId";
    }

    public Date getStartActiveDate() {
        return this.startActiveDate;
    }

    public void setStartActiveDate(Date startActiveDate) {
        this.startActiveDate = startActiveDate;
    }

    public Date getEndActiveDate() {
        return this.endActiveDate;
    }

    public void setEndActiveDate(Date endActiveDate) {
        this.endActiveDate = endActiveDate;
    }

    public String getEnableFlag() {
        return this.enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }
}
