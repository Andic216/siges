package pe.org.ac.siges.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.org.ac.siges.dao.VehiculoDao;
import pe.org.ac.siges.domain.Vehiculo;

@Repository("vehiculoDao")
public class VehiculoDaoImpl implements VehiculoDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public void save(Vehiculo obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("vehiculoXml.insert", obj);
		} finally {
			session.commit();
			session.close();
		}
	}

	public List<Vehiculo> getAll(Vehiculo obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectList("vehiculoXml.get", obj);
		} finally {
			session.close();
		}
	}

	public Vehiculo get(Vehiculo obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectOne("vehiculoXml.get", obj);
		} finally {
			session.close();
		}
	}

	public void update(Vehiculo obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("vehiculoXml.update", obj);
		} finally {
			session.commit();
			session.close();
		}
	}

	public void delete(Vehiculo obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("vehiculoXml.delete", obj);
		} finally {
			session.commit();
			session.close();
		}
	}

}
