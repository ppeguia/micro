package com.interware.microservicios.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.interware.microservicios.dao.UsuarioDAO;
import com.interware.microservicios.entity.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public List<Usuario> findByEmpresa(String empresa) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("findEmpresa");  
        query.setParameter("idEmpresa", empresa);
        List<Usuario> reult = (List<Usuario>) query.list();
        return reult;
	}

	@Override
	public List<Usuario> findByEmpresa(String empresa, String usuario) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("findUsuarioByEmpresa");  
        query.setParameter("idEmpresa", empresa).setParameter("usuario", usuario);
        List<Usuario> reult = (List<Usuario>) query.list();
        return reult;
	}

	@Override
	public String insertUsuario(Usuario usr) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(usr);
		session.flush();
		return usr.getUsuario();
	}

	@Override
	public String updateUsuario(Usuario usr) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(usr);
		session.flush();
		return usr.getUsuario();
	}
	
}
