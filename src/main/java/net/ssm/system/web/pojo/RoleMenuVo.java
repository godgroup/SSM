package net.ssm.system.web.pojo;

import java.util.List;

/**
 * Created by user on 2017/11/17.
 */
public class RoleMenuVo    {
    private Long roleId;

    private String roleName;
    private List<SysMenu> roleMenuList;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<SysMenu> getRoleMenuList() {
        return roleMenuList;
    }

    public void setRoleMenuList(List<SysMenu> roleMenuList) {
        this.roleMenuList = roleMenuList;
    }
}
