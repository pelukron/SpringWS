package com.example.demo.controller;

import com.example.demo.dao.impl.ArticuloImpl;
import com.example.demo.model.Articulo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Presentacion on 23/10/2015.
 */
@RestController
public class ArticuloController {

    @RequestMapping(value = "articulos")
    public List<Articulo> articulos(){
        return new ArticuloImpl().buscarSubFamilia();
    }
}
