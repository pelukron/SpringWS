package com.example.demo.dao;

import com.example.demo.model.Articulo;

import java.util.List;

/**
 * Created by Presentacion on 23/10/2015.
 */
public interface ArticuloDao {
    Articulo buscarArticulo(String id);
    List<Articulo> buscarSubFamilia(String name);
    List<Articulo> articulos();
}
