package com.java321.so.service;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.java321.so.db.dao.UrlDAO;
import com.java321.so.exception.DAOException;
import com.java321.so.module.UrlVO;

public class UrlDBService extends AbstractUrlService {

	Log log = LogFactory.getLog(UrlDBService.class);

	private UrlDAO urlDAO;

	public void setUrlDAO(UrlDAO urlDAO) {
		this.urlDAO = urlDAO;
	}

	@Override
	public List<UrlVO> getAllUrls() {
		List<UrlVO> urls = null;
		try {
			urls = this.urlDAO.queryAllUrls();
		} catch (DAOException e) {
			log.error("Catch Error When queryAllUrls From DB", e);
		}
		return urls;
	}

	@Override
	public boolean saveUrls(Set<UrlVO> urls) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getSingleUrlsStr() {
		List<String> urls = null;
		try {
			urls = this.urlDAO.querySingleUrls();
		} catch (DAOException e) {
			log.error("Get Single Urls Error", e);
		}
		return urls;
	}

	@Override
	public List<String> getIncrementalSingleUrlsStr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UrlVO getSingleUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertIncrementalUrl(String url) {
		// TODO Auto-generated method stub
		
	}

}
