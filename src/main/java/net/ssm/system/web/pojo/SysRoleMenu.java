package net.ssm.system.web.pojo;

public class SysRoleMenu {
    private Long id;

    private Long sys_role_id;

    private Long sys_menu_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSys_role_id() {
        return sys_role_id;
    }

    public void setSys_role_id(Long sys_role_id) {
        this.sys_role_id = sys_role_id;
    }

    public Long getSys_menu_id() {
        return sys_menu_id;
    }

    public void setSys_menu_id(Long sys_menu_id) {
        this.sys_menu_id = sys_menu_id;
    }
}