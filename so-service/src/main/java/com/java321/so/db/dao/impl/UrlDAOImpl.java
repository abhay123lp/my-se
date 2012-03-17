package com.java321.so.db.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.java321.so.db.dao.UrlDAO;
import com.java321.so.exception.DAOException;
import com.java321.so.module.UrlVO;

public class UrlDAOImpl implements UrlDAO {

	private SqlMapClientTemplate sqlMapClientTemplate;

	public void setSqlMapClientTemplate(
			SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UrlVO> queryAllUrls() throws DAOException {

		return this.sqlMapClientTemplate.queryForList("UrlDAO.queryAllUrls");
	}

	@Override
	public UrlVO queryUrlById(long id) throws DAOException {
		Map<String, Object> paras = new HashMap<String, Object>();
		paras.put("id", id);
		return (UrlVO) this.sqlMapClientTemplate.queryForObject(
				"UrlDAO.queryUrlById", paras);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UrlVO> queryUrlsByFatherId(long id) throws DAOException {
		Map<String, Object> paras = new HashMap<String, Object>();
		paras.put("id", id);
		return this.sqlMapClientTemplate.queryForList(
				"UrlDAO.queryUrlsByFatherId", paras);
	}

	@Override
	public long insertUrl(UrlVO url) throws DAOException {

		return (Long) this.sqlMapClientTemplate.queryForObject(
				"UrlDAO.insertUrl", url);
	}

	@Override
	public List<String> querySingleUrls() throws DAOException {
		
		return this.sqlMapClientTemplate.queryForList("UrlDAO.querySingleUrls");
	}

}
