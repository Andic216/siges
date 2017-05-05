package pe.org.ac.siges.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.org.ac.siges.dao.DestinoDao;
import pe.org.ac.siges.domain.Destino;

@Repository("destinoDao")
public class DestinoDaoImpl implements DestinoDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public void save(Destino obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("destinoXml.insert", obj);
		} finally {
			session.commit();
			session.close();
		}
	}

	public List<Destino> getAll(Destino obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectList("destinoXml.get", obj);
		} finally {
			session.close();
		}
	}

	public Destino get(Destino obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectOne("destinoXml.get", obj);
		} finally {
			session.close();
		}
	}

	public void update(Destino obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("destinoXml.update", obj);
		} finally {
			session.commit();
			session.close();
		}
	}

	public void delete(Destino obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("destinoXml.delete", obj);
		} finally {
			session.commit();
			session.close();
		}
	}

}
