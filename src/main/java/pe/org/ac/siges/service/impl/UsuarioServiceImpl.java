package pe.org.ac.siges.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.org.ac.siges.dao.UsuarioDao;
import pe.org.ac.siges.domain.Usuario;
import pe.org.ac.siges.service.UsuarioService;


@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;


	public Usuario get(Usuario pro) throws Exception {
		return usuarioDao.get(pro);
	}

}
