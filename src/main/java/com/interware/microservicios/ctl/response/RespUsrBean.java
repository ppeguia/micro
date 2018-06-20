package com.interware.microservicios.ctl.response;

import java.util.List;

public class RespUsrBean extends ResponseBean {
	
	private List<UsuarioBean> usuarios;
	
	public RespUsrBean(String status, String mesasaje) {
		super(status, mesasaje);
		// TODO Auto-generated constructor stub
	}

	public RespUsrBean(String status, String mesasaje, List<UsuarioBean> usuarios) {
		super(status, mesasaje);
		this.usuarios = usuarios;
	}


	public List<UsuarioBean> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioBean> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	

}
