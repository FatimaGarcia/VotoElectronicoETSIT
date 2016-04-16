package com.upm.isst.voto.dao;


import java.util.List; 


import com.upm.isst.voto.model.ProvinciasModel;

public interface ProvinciasDAO {
	public ProvinciasModel create(String nombre, int numeroCandidatos);
	public List<ProvinciasModel> read();
	public int readNumeroCandidatos(String nombre);
	public ProvinciasModel readNombre(String nombre);
	

}
