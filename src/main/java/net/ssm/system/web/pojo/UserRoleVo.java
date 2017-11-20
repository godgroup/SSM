package net.ssm.system.web.pojo;

import java.util.List;

/**
 * 用户角色pojo
 */
public class UserRoleVo {
    private String loginName;
    private Long uid;
    private List<SysRole> roleList;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }
}
