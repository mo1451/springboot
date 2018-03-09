package com.mo1451.boot.mybatis.dto;

import javax.persistence.Table;

@Table(name = "sys_permission_rule")
public class Permission {
    private int ruleId;
    //权限名称
    private String ruleCode;

    //权限描述
    private String ruleName;

    //授权链接
    private String permissionField;

    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getPermissionField() {
        return permissionField;
    }

    public void setPermissionField(String permissionField) {
        this.permissionField = permissionField;
    }
}
