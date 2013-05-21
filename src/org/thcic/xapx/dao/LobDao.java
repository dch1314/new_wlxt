package org.thcic.xapx.dao;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.stereotype.Repository;


@Repository
public class LobDao extends JdbcTemplateDao {
	protected static final Log logger = LogFactory.getLog(LobDao.class);

	@Autowired
	LobHandler lobHandler;

	private final String sqlSelectPhoto = "select PHOTO from EXAMINEE_PHOTO where EXAMINEE_ID=? ";
	private final String sqlInsertPhoto = "insert into EXAMINEE_PHOTO (EXAMINEE_ID,PHOTO,TYPE) VALUES (?,?,?) ";
	private final String sqlDeletePhoto = "delete from EXAMINEE_PHOTO where EXAMINEE_ID=? ";

	public InputStream getPhotoAsStream(Long examinee_id) {
		return queryForObject(sqlSelectPhoto, new Object[] { examinee_id },
				new RowMapper<InputStream>() {
					public InputStream mapRow(ResultSet rs, int i)
							throws SQLException {
						return lobHandler.getBlobAsBinaryStream(rs, "PHOTO");
					}
				});
	}

	public byte[] getPhotoAsBytes(Long examinee_id) {
		return queryForObject(sqlSelectPhoto, new Object[] { examinee_id },
				new RowMapper<byte[]>() {
					public byte[] mapRow(ResultSet rs, int i)
							throws SQLException {
						return lobHandler.getBlobAsBytes(rs, "PHOTO");
					}
				});
	}

	public int insertPhotoAsStream(final Long examinee_id, final InputStream is) {
		int result = execute(sqlInsertPhoto,
				new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, examinee_id);

						// TODO
						// length
						lobCreator.setBlobAsBinaryStream(ps, 2, is, 0);

						// TODO
						// Photo Type
						ps.setString(3, "jpeg");
					}
				});
		return result;
	}

	public int insertPhotoAsBytes(final Long examinee_id, final byte[] bytes) {
		return execute(sqlInsertPhoto,
				new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, examinee_id);
						lobCreator.setBlobAsBytes(ps, 2, bytes);

						// TODO
						// Photo Type
						ps.setString(3, "gif");
					}
				});
	}

	public int deletePhoto(final Long examinee_id) {
		if (examinee_id == null) {
			return 0;
		}
		return update(sqlDeletePhoto, new Object[] { examinee_id });
	}
}
