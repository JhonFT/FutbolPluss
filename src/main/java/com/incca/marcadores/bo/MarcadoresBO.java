/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.marcadores.bo;

import com.incca.marcadores.dao.MarcadorDAO;
import com.incca.marcadores.tdo.Result;

/**
 *
 * @author JohnF
 */
public class MarcadoresBO {
      MarcadorDAO dAO;

    public MarcadoresBO() {
        dAO = new MarcadorDAO();
    }

    public Result getAll() {
        Result response = new Result();
        if (dAO.getAll() != null) {
            response.setStatus(200);
            response.setData(dAO.getAll());
        } else {
            response.setStatus(500);
            response.setData("Error en el servicio equipos");
        }

        return response;
    }
}
