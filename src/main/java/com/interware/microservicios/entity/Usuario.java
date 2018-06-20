package com.interware.microservicios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="usuario")
@NamedQueries({
    @NamedQuery(
        name = "findEmpresa",
        query = "from Usuario u where u.idEmpresa = :idEmpresa"
        ),
    @NamedQuery(
            name = "findUsuarioByEmpresa",
            query = "from Usuario u where u.idEmpresa = :idEmpresa and u.usuario = :usuario"
            ),    
})
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	@Column(name = "idUsuario", updatable = false, nullable = false)
    private int id; 
    
	@Column(name = "usuario")
    private String usuario;
    
	@Column(name = "password") 
    private String password;
    
	@Column(name = "idEmpresa") 
    private String idEmpresa;
	
	@Column(name = "activo") 
    private int activo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	
	
}
