/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.marcadores.dao;

import com.incca.marcadores.helper.ConnectionDB;
import com.incca.marcadores.interfaces.ImplementInterface;
import com.incca.marcadores.tdo.Equipos;
import com.incca.marcadores.tdo.Marcadores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JohnF
 */
public class MarcadorDAO implements ImplementInterface<Marcadores> {

    private ConnectionDB conn;
    private static final String SELECTSQL = "SELECT * FROM RESULTADOS";
    private static final String GETEQUIPORESULSQL = "SELECT E.EQU_CODE, E.EQU_NOMBRE, E.EQU_ESCUDO, M.MAR_LOCAL, M.MAR_ANOTACION FROM RESULTADOS R  INNER JOIN MARCADORES M  ON  R.RES_CODE = M.MAR_RESULTADO\n"
            + "INNER JOIN EQIPOS E ON E.EQU_CODE = M.MAR_EQUIPO WHERE R.RES_CODE = ?";

    public MarcadorDAO() {
        conn = new ConnectionDB();
    }

    @Override
    public List<Marcadores> getAll() {
        try {
            List<Marcadores> marcadores = new ArrayList<>();
            Statement ps = conn.getConnection().createStatement();
            ResultSet rs = ps.executeQuery(SELECTSQL);
            while (rs.next()) {
                Marcadores e = new Marcadores();
                e.setFeCreacion(rs.getDate("RES_FECREACION"));
                e.setFeEncuentro(rs.getDate("RES_FEENCUENTRO"));
                PreparedStatement p = conn.getConnection().prepareStatement(GETEQUIPORESULSQL);
                p.setInt(1, rs.getInt("RES_CODE"));
                ResultSet r = p.executeQuery();
                while (r.next()) {
                    Equipos equ = new Equipos();
                    equ.setEscudo(r.getBytes("EQU_ESCUDO"));
                    equ.setNombre(r.getString("EQU_NOMBRE"));
                    if (r.getBoolean("MAR_LOCAL")) {
                        e.setLocal(equ);
                        e.setResultadoL(r.getInt("MAR_ANOTACION"));
                    } else {
                        e.setVisitante(equ);
                        e.setResultadoV(r.getInt("MAR_ANOTACION"));
                    }
                }
                marcadores.add(e);
            }
            return marcadores;
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Marcadores find(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Marcadores t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Marcadores t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
