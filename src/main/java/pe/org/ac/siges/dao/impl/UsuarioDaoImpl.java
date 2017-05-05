package pe.org.ac.siges.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.org.ac.siges.dao.UsuarioDao;
import pe.org.ac.siges.domain.Usuario;


@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public Usuario get(Usuario pro) throws Exception {
		Usuario prov = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			prov = session.selectOne("usuarioXml.get", pro);
		} finally {
			session.close();
		}
		return prov;
	}

}
