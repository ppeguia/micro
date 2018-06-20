package com.interware.microservicios.ctl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.interware.microservicios.ctl.request.UsuarioIdResqBean;
import com.interware.microservicios.ctl.request.UsuarioResqBean;
import com.interware.microservicios.ctl.response.RespUsrBean;
import com.interware.microservicios.serv.UsuarioServ;

import io.swagger.annotations.Api;

@Api(value = "Usuarios")
@RestController
public class UsuarioController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UsuarioServ usrServ;
		
	@GetMapping("/usuario/all/{empresa}")
	public RespUsrBean usuarioAllEmpresa(@PathVariable String empresa) {
		logger.info("Controler: UsuarioController - Metodo: usuarioAllEmpresa - START"); 
		RespUsrBean response = usrServ.usuarioEmpresa(empresa);
	    logger.info("Controler: UsuarioController - Metodo: usuarioAllEmpresa - END");
	    return response;
	}
	
	@GetMapping("/usuario/{empresa}/usr/{usuario}")
	public RespUsrBean usuarioAllEmpresaUsuario(@PathVariable String empresa, @PathVariable String usuario) {
		logger.info("Controler: UsuarioController - Metodo: usuarioAllEmpresaUsuario - START"); 
		RespUsrBean response = usrServ.usuarioEmpresaUsr(empresa,usuario);
	    logger.info("Controler: UsuarioController - Metodo: usuarioAllEmpresaUsuario - END");
	    return response;
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public RespUsrBean ingresarUsuario(@RequestBody UsuarioResqBean usuario) {
		logger.info("Controler: UsuarioController - Metodo: ingresarUsuario - START"); 
		RespUsrBean response = usrServ.usuarioInsert(usuario);
	    logger.info("Controler: UsuarioController - Metodo: ingresarUsuario - END");
	    return response;
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.PUT)
	public RespUsrBean updateUsuario(@RequestBody UsuarioIdResqBean usuario) {
		logger.info("Controler: UsuarioController - Metodo: updateUsuario - START"); 
		RespUsrBean response = usrServ.usuarioUpdate(usuario);
	    logger.info("Controler: UsuarioController - Metodo: updateUsuario - END");
	    return response;
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.DELETE)
	public RespUsrBean deleteUsuario(@RequestBody UsuarioIdResqBean usuario) {
		logger.info("Controler: UsuarioController - Metodo: updateUsuario - START"); 
		RespUsrBean response = usrServ.usuarioDelete(usuario);
	    logger.info("Controler: UsuarioController - Metodo: updateUsuario - END");
	    return response;
	}
	
	
}