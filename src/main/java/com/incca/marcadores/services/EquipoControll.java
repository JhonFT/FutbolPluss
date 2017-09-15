/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.marcadores.services;

import com.incca.marcadores.bo.EquiposBO;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author JohnF
 */
@Path("equipo")
public class EquipoControll {

    EquiposBO equiposBO;

    /*
     * Creates a new instance of EquipoControll
     */
    public EquipoControll() {
        equiposBO = new EquiposBO();
    }

    /**
     * Retrieves representation of an instance of
     * com.incca.marcadores.services.EquipoControll
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getXml() {
        return Response.ok(equiposBO.getAll()).build();
    }

    /**
     * PUT method for updating or creating an instance of EquipoControll
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
        
    }
}
