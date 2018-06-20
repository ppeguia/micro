package com.interware.microservicios.ctl.response;

public class ResponseBean {

	private String status;
	private String mesasaje;
	
	public ResponseBean(String status, String mesasaje) {
		super();
		this.status = status;
		this.mesasaje = mesasaje;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMesasaje() {
		return mesasaje;
	}

	public void setMesasaje(String mesasaje) {
		this.mesasaje = mesasaje;
	}
}
