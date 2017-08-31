package net.ssm.system.web.pojo;

public class SysUserRole {
    private Long id;

    private Long sys_user_id;

    private Long sys_role_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSys_user_id() {
        return sys_user_id;
    }

    public void setSys_user_id(Long sys_user_id) {
        this.sys_user_id = sys_user_id;
    }

    public Long getSys_role_id() {
        return sys_role_id;
    }

    public void setSys_role_id(Long sys_role_id) {
        this.sys_role_id = sys_role_id;
    }
}