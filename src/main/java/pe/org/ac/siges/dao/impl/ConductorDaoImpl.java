package pe.org.ac.siges.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.org.ac.siges.dao.ConductorDao;
import pe.org.ac.siges.domain.Conductor;

@Repository("conductorDao")
public class ConductorDaoImpl implements ConductorDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public void save(Conductor obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("conductorXml.insert", obj);
		} finally {
			session.commit();
			session.close();
		}
	}

	public List<Conductor> getAll(Conductor obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectList("conductorXml.get", obj);
		} finally {
			session.close();
		}
	}

	public Conductor get(Conductor obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectOne("conductorXml.get", obj);
		} finally {
			session.close();
		}
	}

	public void update(Conductor obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("conductorXml.update", obj);
		} finally {
			session.commit();
			session.close();
		}
	}

	public void delete(Conductor obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("conductorXml.delete", obj);
		} finally {
			session.commit();
			session.close();
		}
	}

}
