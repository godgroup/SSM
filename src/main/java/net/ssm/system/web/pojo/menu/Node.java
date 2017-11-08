package net.ssm.system.web.pojo.menu;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Node {
	
	
	/**
	 * 节点名称
	 */
	private String name;
	private int id;
	private int parentid;
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
