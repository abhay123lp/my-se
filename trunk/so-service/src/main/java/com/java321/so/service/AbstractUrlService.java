package com.java321.so.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.java321.so.module.UrlVO;

public abstract class AbstractUrlService {

	/**
	 * 获取存储的所有url
	 * @return
	 */
	public abstract List<UrlVO> getAllUrls();

	/**
	 * 存储新url
	 * @param urls
	 * @return
	 */
	public abstract boolean saveUrls(Set<UrlVO> urls);
	
	/**
	 * 只获取所有url的地址
	 * @return
	 */
	public abstract List<String> getSingleUrlsStr();
	
	/**
	 * 只获取所有增量url的地址
	 * @return
	 */
	public abstract List<String> getIncrementalSingleUrlsStr();
	
	/**
	 * 通过url地址获取单个url
	 * @param url
	 * @return
	 */
	public abstract UrlVO getSingleUrl(String url);
	
	/**
	 * 添加Url进队列，去重并且判断是否在url库中已存在
	 * @param url
	 */
	public abstract void insertIncrementalUrl(List<String> url);
	
	/**
	 * 判断url是否在存储中已存在
	 * @param url
	 * @return true表示存储中存在该url
	 */
	public boolean isUrlExists(String url){
	
		return getSingleUrl(url) != null;
	}

	/**
	 * 去除urls中重复的url
	 * @param urls
	 * @return
	 */
	public Set<String> eliminatingDuplicationUrl(List<String> urls) {

		Set<String> res = new HashSet<String>();
		for (String url : urls) {
			res.add(url);
		}

		return res;
	}
	
	
}
