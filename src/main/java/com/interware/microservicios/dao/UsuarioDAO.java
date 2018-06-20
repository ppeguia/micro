package com.interware.microservicios.dao;

import java.util.List;

import com.interware.microservicios.entity.Usuario;

public interface UsuarioDAO {
	/**
	 * Obtiente los usuarios por empresa
	 * @param empresa
	 * @return
	 */
	List<Usuario> findByEmpresa(String empresa);

	/**
	 * Obtiene los usuarios por empresa y usuario
	 * @param empresa
	 * @param usuario
	 * @return
	 */
	List<Usuario> findByEmpresa(String empresa, String usuario);

	/**
	 * Inserta un usuario a la base de datos
	 * @param empresa
	 * @param usuario
	 * @return
	 */
	String insertUsuario(Usuario serEntityResq);

	/**
	 * Actualiza el usuario a la base de datos
	 * @param empresa
	 * @param usuario
	 * @return
	 */
	String updateUsuario(Usuario usr);
}
