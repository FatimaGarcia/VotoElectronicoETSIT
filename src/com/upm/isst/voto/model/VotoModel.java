package com.upm.isst.voto.model;

import java.math.BigInteger;
import java.security.*;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class VotoModel {
	private String idCEE = "grupo2ISST";
	private BigInteger numAleatorio;
	
	public String getIdCEE() {
		return idCEE;
	}
	private void setIdCEE(String idCEE) {
		this.idCEE = idCEE;
	}
	private BigInteger getNumAleatorio() {
		BigInteger serial = BigInteger.valueOf(System.currentTimeMillis());
		this.numAleatorio = serial;
		return numAleatorio;
	}
	private void setNumAleatorio(BigInteger numAleatorio) {
		this.numAleatorio = numAleatorio;
	}
	
	public String buildVoto(String [] codPoliticos){
		
		String voto = "";
		BigInteger numAleatorio = getNumAleatorio();
		String num = numAleatorio.toString();
		String idCEE = getIdCEE();
		String [] codigos = new String[3];
		for(int i = 0; i<codPoliticos.length; i++){
			if(codPoliticos[i] != null){
				codigos[i] = codPoliticos[i].substring(0,2);
			}
		}
		for(int j=0; j<codigos.length; j++){
			if(codigos[j] == null){
				codigos[j] = "0";
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(idCEE);
		stringBuilder.append("-");
		stringBuilder.append(num.substring(0,10));
		stringBuilder.append("-");
		stringBuilder.append(codigos[0]);
		stringBuilder.append("-");
		stringBuilder.append(codigos[1]);
		stringBuilder.append("-");
		stringBuilder.append(codigos[2]);
		voto = stringBuilder.toString(); 
		return voto;
	}
}
