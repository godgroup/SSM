package net.ssm.system.web.pojo.menu;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Node {
	
	
	/**
	 * 节点名称
	 */
	private String name;
	private String title;
	private long id;
	private long parentid;
	public long getParentid() {
		return parentid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setParentid(long parentid) {
		this.parentid = parentid;
	}
	 private String icon;
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	private String alias;
	private boolean spread;
	private String href;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public boolean isSpread() {
		return spread;
	}
	public void setSpread(boolean spread) {
		this.spread = spread;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	 
	private List<Node> children;
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
	
	
}
