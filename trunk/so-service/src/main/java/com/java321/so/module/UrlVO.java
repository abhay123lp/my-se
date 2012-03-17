package com.java321.so.module;

public class UrlVO {

	private long id;
	private String url;
	private String tree;
	private long father;
	private boolean root;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTree() {
		return tree;
	}
	public void setTree(String tree) {
		this.tree = tree;
	}
	public long getFather() {
		return father;
	}
	public void setFather(long father) {
		this.father = father;
	}
	public boolean isRoot() {
		return root;
	}
	public void setRoot(boolean root) {
		this.root = root;
	}
	
}
