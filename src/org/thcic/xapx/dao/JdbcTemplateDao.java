package org.thcic.xapx.dao;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.thcic.xapx.exception.JdbcException;


@Repository
public class JdbcTemplateDao {
	protected static final Log logger = LogFactory
			.getLog(JdbcTemplateDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public <T> List<T> query(String sql, RowMapper<T> rowMapper)
			throws JdbcException {
		return query(sql, rowMapper, (Object[]) null);
	}

	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... args)
			throws JdbcException {
		long startTime = new Date().getTime();
		List<T> list = null;
		try {
			list = this.jdbcTemplate.query(sql, rowMapper, args);
		} catch (DataAccessException dae) {
			logger.debug(dae, dae);
			return Collections.emptyList();
		}
		logger.info(this.getLog(sql, new Date().getTime() - startTime));
		return list;
	}

	/**
	 * query.
	 * 
	 * 根据一列或者几列查询返回对象
	 * 
	 * @param sql
	 * @param object
	 * @param rm
	 */
	public <T> T queryForObject(String sql, Object[] args, RowMapper<T> rm)
			throws JdbcException {
		long startTime = new Date().getTime();
		T t = null;
		try {
			t = jdbcTemplate.queryForObject(sql, args, rm);
		} catch (DataAccessException dae) {
			logger.debug(dae, dae);
			return null;
		}
		logger.info(this.getLog(sql, new Date().getTime() - startTime));
		return t;
	}

	public <T> T queryForObject(String sql, Class<T> requiredType,
			Object... args) throws JdbcException {
		long startTime = new Date().getTime();
		T t = null;
		try {
			t = jdbcTemplate.queryForObject(sql, requiredType, args);
		} catch (DataAccessException dae) {
			logger.debug(dae, dae);
			return null;
		}
		logger.info(this.getLog(sql, new Date().getTime() - startTime));
		return t;
	}

	/**
	 * query.
	 * 
	 * 计算总记录数
	 * 
	 * @param sql
	 */
	public int queryForInt(String sql) throws JdbcException {
		long startTime = new Date().getTime();
		int n = this.jdbcTemplate.queryForInt(sql);

		logger.info(this.getLog(sql, new Date().getTime() - startTime));
		return n;
	}

	/**
	 * query.
	 * 
	 * 返回符合条件所有记录
	 * 
	 * @param sql
	 * @param object
	 */
	public <T> List<T> queryForList(String sql, Class<T> elementType,
			Object[] args) throws JdbcException {
		long startTime = new Date().getTime();
		List<T> list = this.jdbcTemplate.queryForList(sql, elementType, args);
		logger.info(getLog(sql, new Date().getTime() - startTime));
		return list;
	}

	/**
	 * query.
	 * 
	 * 返回复合条件所有记录
	 * 
	 * @param sql
	 * @param object
	 */
	@SuppressWarnings("unchecked")
	public List<Object> queryForList(String sql, Object[] object)
			throws JdbcException {
		long startTime = new Date().getTime();
		@SuppressWarnings("rawtypes")
		List list = this.jdbcTemplate.queryForList(sql, object);

		logger.info(getLog(sql, new Date().getTime() - startTime));
		return list;
	}

	/**
	 * query.
	 * 
	 * 返回复合条件所有记录
	 * 
	 * @param sql
	 * @param object
	 */
	@SuppressWarnings("unchecked")
	public List<Object> queryForList(String sql) throws JdbcException {
		long startTime = new Date().getTime();
		@SuppressWarnings("rawtypes")
		List list = this.jdbcTemplate.queryForList(sql);

		logger.info(getLog(sql, new Date().getTime() - startTime));
		return list;
	}

	/**
	 * UPDATE或INSERT.
	 * 
	 * 不带参数update or insert or delete
	 * 
	 * @param sql
	 */

	public int update(String sql) {
		long startTime = new Date().getTime();
		int n = this.jdbcTemplate.update(sql);

		logger.info(getLog(sql, new Date().getTime() - startTime));
		return n;
	}

	/**
	 * UPDATE或INSERT.
	 * 
	 * 带参数update or insert or delete
	 * 
	 * @param sql
	 * @param object
	 */

	public int update(String sql, Object[] object) throws JdbcException {
		long startTime = new Date().getTime();
		int n = jdbcTemplate.update(sql, object);
		logger.info(getLog(sql, new Date().getTime() - startTime));
		return n;
	}

	/**
	 * execute
	 * 
	 * 执行sql语句
	 * 
	 * @param sql
	 */

	public void execute(String sql) throws JdbcException {
		long startTime = new Date().getTime();
		jdbcTemplate.execute(sql);
		logger.info(getLog(sql, new Date().getTime() - startTime));
	}

	public <T> T execute(String sql, PreparedStatementCallback<T> action)
			throws JdbcException {
		long startTime = new Date().getTime();
		T result = jdbcTemplate.execute(sql, action);
		logger.info(getLog(sql, new Date().getTime() - startTime));
		return result;
	}

	/**
	 * 获得seq最大值
	 * 
	 * @param seqName
	 * @return
	 */
	public Long getSeqByName(String seqName) {
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		sql.append(seqName + "." + "nextVal ");
		sql.append("as seq from dual");
		return jdbcTemplate.queryForObject(sql.toString(), Long.class);
	}

	/**
	 * 生成log
	 * 
	 * @param sql
	 * @param time
	 * @return
	 */
	public String getLog(String sql, long time) {
		StringBuffer temp = new StringBuffer();
		temp.append(sql);
		temp.append(" --- ");
		temp.append(time);
		temp.append("毫秒");
		return temp.toString();
	}
}
