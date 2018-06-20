package com.interware.microservicios.serv.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interware.microservicios.ctl.request.UsuarioIdResqBean;
import com.interware.microservicios.ctl.request.UsuarioResqBean;
import com.interware.microservicios.ctl.response.RespUsrBean;
import com.interware.microservicios.ctl.response.UsuarioBean;
import com.interware.microservicios.dao.UsuarioDAO;
import com.interware.microservicios.entity.Usuario;
import com.interware.microservicios.enums.Activo;
import com.interware.microservicios.enums.Empresa;
import com.interware.microservicios.serv.UsuarioServ;

@Service
@Transactional
public class UsuarioServImpl implements UsuarioServ  {

	@Autowired
	private UsuarioDAO usrDao;

	@Override
	public RespUsrBean usuarioEmpresa(String empresa) {
		List<Usuario> usr = usrDao.findByEmpresa(empresa);
		return setResponse(usr,"Consultar todos");
	}

	@Override
	public RespUsrBean usuarioEmpresaUsr(String empresa, String usuario) {
		List<Usuario> usr = usrDao.findByEmpresa(empresa,usuario);
		return setResponse(usr,"Constular");
	}
	
	@Override
	public RespUsrBean usuarioInsert(UsuarioResqBean usuario) {
		Usuario usr = serEntityResq(usuario);
		usr.setId(0);
		String resul = usrDao.insertUsuario(usr);
		List<Usuario> usrs = usrDao.findByEmpresa(usuario.getEmpresa(),resul);
		return setResponse(usrs,"Insertar");
	}

	@Override
	public RespUsrBean usuarioUpdate(UsuarioIdResqBean usuario) {
		String resul = usrDao.updateUsuario(serEntityResq(usuario));
		List<Usuario> usr = usrDao.findByEmpresa(usuario.getEmpresa(),resul);
		return setResponse(usr,"Actualizar");
	}

	@Override
	public RespUsrBean usuarioDelete(UsuarioIdResqBean usuario) {
		Usuario usr = serEntityResq(usuario);
		usr.setActivo(0);
		String resul = usrDao.updateUsuario(usr);
		List<Usuario> usrs = usrDao.findByEmpresa(usuario.getEmpresa(),resul);
		return setResponse(usrs,"Eliminar");
	}
	
	private Usuario serEntityResq(UsuarioIdResqBean usuario) {
		Usuario resul = new Usuario();
		resul.setId( Integer.parseInt(usuario.getIdUsuario()) );
		resul.setActivo( Integer.parseInt(usuario.getActivo()));
		resul.setIdEmpresa(usuario.getEmpresa());
		resul.setPassword(usuario.getPassword());
		resul.setUsuario(usuario.getUsuario());
		return resul;
	}

	private Usuario serEntityResq(UsuarioResqBean usuario) {
		Usuario resul = new Usuario();
		resul.setActivo( Integer.parseInt(usuario.getActivo()));
		resul.setIdEmpresa(usuario.getEmpresa());
		resul.setPassword(usuario.getPassword());
		resul.setUsuario(usuario.getUsuario());
		return resul;
	}

	private RespUsrBean setResponse(List<Usuario> usrs, String mensaje) {
		List<UsuarioBean> usrRest = new ArrayList<UsuarioBean>();
		for(Usuario usr : usrs) {
			String empresa = fijaEmpresa(usr.getIdEmpresa());
			String activo = fijaActivo(usr.getActivo());
			usrRest.add(new UsuarioBean(String.valueOf(usr.getId()),
	                usr.getUsuario(),usr.getPassword(),
	                usr.getIdEmpresa(),
	                String.valueOf(usr.getActivo())));
		}
		return new RespUsrBean("0", "Exitoso:= " + mensaje, usrRest);
	}

	private String fijaActivo(int activo) {
		String result = "";
		if( activo  == Activo.ACTIVO.getValor() ) {
			result = Activo.ACTIVO.getDescricion();
		}else if(activo  == Activo.NO_ACTIVO.getValor() ) {
			result = Activo.NO_ACTIVO.getDescricion();
		}else {
			result = activo + ":= sin especificar";
		}	
		return result;
	}

	private String fijaEmpresa(String idEmpresa) {
		String result = "";
		if(idEmpresa.equalsIgnoreCase(Empresa.EMPRESA01.getValor())) {
			result = Empresa.EMPRESA01.getDescricion();
		}else if(idEmpresa.equalsIgnoreCase(Empresa.EMPRESA02.getValor())) {
			result = Empresa.EMPRESA02.getDescricion();
		}else {
			result = idEmpresa + ":= sin especificar";
		}	
		return result;
	}
	
}
