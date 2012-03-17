package com.java321.so.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.java321.so.module.UrlVO;

public abstract class AbstractUrlService {

	/**
	 * ��ȡ�洢������url
	 * @return
	 */
	public abstract List<UrlVO> getAllUrls();

	/**
	 * �洢��url
	 * @param urls
	 * @return
	 */
	public abstract boolean saveUrls(Set<UrlVO> urls);
	
	/**
	 * ֻ��ȡ����url�ĵ�ַ
	 * @return
	 */
	public abstract List<String> getSingleUrlsStr();
	
	/**
	 * ֻ��ȡ��������url�ĵ�ַ
	 * @return
	 */
	public abstract List<String> getIncrementalSingleUrlsStr();
	
	/**
	 * ͨ��url��ַ��ȡ����url
	 * @param url
	 * @return
	 */
	public abstract UrlVO getSingleUrl(String url);
	
	/**
	 * ���Url�����У�ȥ�ز����ж��Ƿ���url�����Ѵ���
	 * @param url
	 */
	public abstract void insertIncrementalUrl(List<String> url);
	
	/**
	 * �ж�url�Ƿ��ڴ洢���Ѵ���
	 * @param url
	 * @return true��ʾ�洢�д��ڸ�url
	 */
	public boolean isUrlExists(String url){
	
		return getSingleUrl(url) != null;
	}

	/**
	 * ȥ��urls���ظ���url
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
