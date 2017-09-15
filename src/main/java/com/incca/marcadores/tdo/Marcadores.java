/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.marcadores.tdo;

import java.sql.Date;


/**
 *
 * @author JohnF
 */
public class Marcadores {

    private Equipos local;
    private Equipos visitante;
    private Integer ResultadoL;
    private Integer ResultadoV;
    private Date feEncuentro;
    private Date feCreacion;
    private Usuarios usuario;

    public Equipos getLocal() {
        return local;
    }

    public void setLocal(Equipos local) {
        this.local = local;
    }

    public Equipos getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipos visitante) {
        this.visitante = visitante;
    }

    public Integer getResultadoL() {
        return ResultadoL;
    }

    public void setResultadoL(Integer ResultadoL) {
        this.ResultadoL = ResultadoL;
    }

    public Integer getResultadoV() {
        return ResultadoV;
    }

    public void setResultadoV(Integer ResultadoV) {
        this.ResultadoV = ResultadoV;
    }

    public Date getFeEncuentro() {
        return feEncuentro;
    }

    public void setFeEncuentro(Date feEncuentro) {
        this.feEncuentro = feEncuentro;
    }

    public Date getFeCreacion() {
        return feCreacion;
    }

    public void setFeCreacion(Date feCreacion) {
        this.feCreacion = feCreacion;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }


}
