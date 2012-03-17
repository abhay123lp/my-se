package com.java321.so.db.dao;

import java.util.List;

import com.java321.so.exception.DAOException;
import com.java321.so.module.UrlVO;

public interface UrlDAO {

	public List<UrlVO> queryAllUrls() throws DAOException;
	
	public List<String> querySingleUrls() throws DAOException;
	
	public List<UrlVO> queryUrlsByFatherId(long id) throws DAOException;
	
	public UrlVO queryUrlById(long id) throws DAOException;
	
	public long insertUrl(UrlVO url) throws DAOException;
}
