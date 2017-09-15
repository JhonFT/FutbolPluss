
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.marcadores.dao;

import com.incca.marcadores.helper.ConnectionDB;
import com.incca.marcadores.interfaces.ImplementInterface;
import com.incca.marcadores.tdo.Equipos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author JohnF
 */
public class EquipoDAO implements ImplementInterface<Equipos> {

    private ConnectionDB conn;
    private static final String INSERTSQL = "INSERT INTO EQIPOS (EQU_NOMBRE,EQU_ESCUDO) VALUES (? ,?)";
    private static final String SELECTSQL = "SELECT * FROM EQIPOS";

    public EquipoDAO() {
        conn = new ConnectionDB();
    }

    @Override
    public List<Equipos> getAll() {
        try {
            List<Equipos> equipos = new ArrayList<>();
            Statement ps = conn.getConnection().createStatement();
            ResultSet rs = ps.executeQuery(SELECTSQL);
            while (rs.next()) {
                Equipos e = new Equipos();
                e.setEscudo(rs.getBytes("equ_escudo"));
                e.setNombre(rs.getString("equ_nombre"));
                equipos.add(e);
            }
            return equipos;
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public Equipos find(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Equipos t) {

        try {
            PreparedStatement ps = conn.getConnection().prepareCall(INSERTSQL);
            ps.setString(1, t.getNombre());
            ps.setBlob(2, new SerialBlob(t.getEscudo()));
            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(EquipoDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            conn.close();
        }

    }

    @Override
    public boolean delete(Equipos t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
