/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.marcadores.interfaces;

import java.util.List;

/**
 *
 * @author JohnF
 * @param <T>
 */
public interface ImplementInterface<T> {

    public List<T> getAll();

    public T find(Long Id);

    public boolean add(T t);

    public boolean delete(T t);
}
