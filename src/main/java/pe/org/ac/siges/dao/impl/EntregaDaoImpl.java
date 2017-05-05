package pe.org.ac.siges.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.org.ac.siges.dao.EntregaDao;
import pe.org.ac.siges.domain.Entrega;
import pe.org.ac.siges.domain.ReporteDesByCon;
import pe.org.ac.siges.domain.ReporteDesByTic;
import pe.org.ac.siges.domain.ReporteDesByVeh;

@Repository("entregaDao")
public class EntregaDaoImpl implements EntregaDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public void save(Entrega obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("entregaXml.insert", obj);
		} finally {
			session.commit();
			session.close();
		}
	}

	public List<Entrega> getAll(Entrega obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectList("entregaXml.get", obj);
		} finally {
			session.close();
		}
	}

	public Entrega get(Entrega obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectOne("entregaXml.get", obj);
		} finally {
			session.close();
		}
	}

	public void update(Entrega obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("entregaXml.update", obj);
		} finally {
			session.commit();
			session.close();
		}
	}

	public void delete(Entrega obj) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("entregaXml.delete", obj);
		} finally {
			session.commit();
			session.close();
		}
	}

	public List<ReporteDesByVeh> getDestinoByVehiculo(Entrega obj) throws Exception {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectList("entregaXml.getRptDbV", obj);
		} finally {
			session.close();
		}
	}

	public List<ReporteDesByCon> getDestinoByConductor(Entrega obj) throws Exception {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectList("entregaXml.getRptDbC", obj);
		} finally {
			session.close();
		}
	}

	public List<ReporteDesByTic> getDestinoByTicket(Entrega obj) throws Exception {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectList("entregaXml.getRptDbT", obj);
		} finally {
			session.close();
		}
	}

}
