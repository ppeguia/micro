package com.interware.microservicios.serv;

import com.interware.microservicios.ctl.request.UsuarioIdResqBean;
import com.interware.microservicios.ctl.request.UsuarioResqBean;
import com.interware.microservicios.ctl.response.RespUsrBean;

public interface UsuarioServ {

	/**
	 * Servicio para obtener usuarios por empresa
	 * @param empresa
	 * @return
	 */
	RespUsrBean usuarioEmpresa(String empresa);

	/**
	 * Servicio para obtener usario por empresa
	 * @param empresa
	 * @param usuario
	 * @return
	 */
	RespUsrBean usuarioEmpresaUsr(String empresa, String usuario);
	
	/**
	 * Insertar un usuario en el sistema
	 * @param usuario
	 * @returnq
	 */
	RespUsrBean usuarioInsert(UsuarioResqBean usuario);
	
	/**
	 * Actualiza los datos del usuario
	 * @param usuario
	 * @return
	 */
	RespUsrBean usuarioUpdate(UsuarioIdResqBean usuario);

	/**
	 * Elimina del sistema al usuario
	 * @param usuario
	 * @return
	 */
	RespUsrBean usuarioDelete(UsuarioIdResqBean usuario);

}
