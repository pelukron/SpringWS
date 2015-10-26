package com.example.demo.controller;

import com.example.demo.dao.impl.ArticuloImpl;
import com.example.demo.model.Articulo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Presentacion on 23/10/2015.
 */
@RestController
public class ArticuloController {

    @RequestMapping(value = "/articulos", method = RequestMethod.GET)
    public List<Articulo> articulos(){
        return new ArticuloImpl().articulos();
    }

    @RequestMapping(value = "/articulos/subfamilias", method = RequestMethod.GET)
    public List<Articulo> subfamilias(@RequestParam(value="name", defaultValue="") String name){
        return new ArticuloImpl().buscarSubFamilia(name);
    }

    @RequestMapping(value = "/articulo", method = RequestMethod.GET)
    public Articulo articulo(@RequestParam(value = "id", defaultValue = "") String id){
        return new ArticuloImpl().buscarArticulo(id);
    }
}
