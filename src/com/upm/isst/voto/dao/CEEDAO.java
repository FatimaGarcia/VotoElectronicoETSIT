package com.upm.isst.voto.dao;

import java.util.List;

import com.upm.isst.voto.model.CEEModel;

public interface CEEDAO {
	public CEEModel create(Long dni, String nombre, String apellido1, String apellido2, 
			 String provincia, String contrasena);
	public List<CEEModel> read();
	public List<CEEModel> readNombre(String nombre);
	public List<CEEModel> readApellido1(String apellido1);
	public List<CEEModel> readApellido2(String apellido2);
	public CEEModel readDNI(Long dni);
	public List<CEEModel> readProvincia(String provincia);
	public Boolean readContrasena(String contrasena, Long dni);
	public Boolean readVoto(Long dni);
	public String readProvincia(Long dni);
	public void update(CEEModel votante);
	public void delete(Long dni);
}
