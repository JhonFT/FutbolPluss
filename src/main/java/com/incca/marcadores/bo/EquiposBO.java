/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.marcadores.bo;

import com.incca.marcadores.dao.EquipoDAO;
import com.incca.marcadores.tdo.Equipos;
import com.incca.marcadores.tdo.EquiposList;
import com.incca.marcadores.tdo.Result;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author JohnF
 */
public class EquiposBO {

    EquipoDAO dAO;

    public EquiposBO() {
        dAO = new EquipoDAO();
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

    public Result add(Equipos equipo) {
        Result response = new Result();
        try {
            URL url = new URL(equipo.getImg());
            BufferedImage originalImage = ImageIO.read(url);
            byte[] imageInByte;
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                ImageIO.write(originalImage, "png", baos);
                baos.flush();
                imageInByte = baos.toByteArray();
            }
            equipo.setEscudo(imageInByte);
            if (dAO.add(equipo)) {
                response.setStatus(200);
                response.setData("Se ha creado el equipo correctamente");
            } else {
                response.setStatus(500);
                response.setData("No se ha creado el equipo intenta de nuevo");
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(EquiposBO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EquiposBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;

    }
}
