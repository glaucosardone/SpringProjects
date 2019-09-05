package com.fantaknight.webapp.domain;

import java.io.Serializable;

public class Ingredienti implements Serializable
{
	 
	private static final long serialVersionUID = -7827637546807241460L;
	
	private String codArt;
	private String info;


    public String getCodArt() {
        return this.codArt;
    }

    public void setCodArt(String codArt) {
        this.codArt = codArt;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
	
	
}
