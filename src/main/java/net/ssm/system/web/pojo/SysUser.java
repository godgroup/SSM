package net.ssm.system.web.pojo;

import java.util.Date;
/*
 * *
 */
public class SysUser {
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLogin_ip() {
		return login_ip;
	}
	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}
	public Date getLongin_time() {
		return longin_time;
	}
	public void setLongin_time(Date longin_time) {
		this.longin_time = longin_time;
	}
	public int getLongin_times() {
		return longin_times;
	}
	public void setLongin_times(int longin_times) {
		this.longin_times = longin_times;
	}
	public String getAvatars() {
		return avatars;
	}
	public void setAvatars(String avatars) {
		this.avatars = avatars;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}
	public Date getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}
	private Long  id;
    private String login_name;
    private String password;
    private String email;
    private String name;
    private String mobile;
    private enum status{
    	disabled,
    	enable
    };

	private String login_ip;
    private Date longin_time;
    private int longin_times;
    private String avatars;
    private String remarks;
    private Date create_at;
    private Date update_at;
}