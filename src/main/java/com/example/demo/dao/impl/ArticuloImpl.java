package com.example.demo.dao.impl;

import com.example.demo.dao.ArticuloDao;
import com.example.demo.dao.ConnectionDao;
import com.example.demo.model.Articulo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Moreno on 23/10/2015.
 */
public class ArticuloImpl extends ConnectionDao implements ArticuloDao{

    private static final String TABLE_NAME_DB = "tblarticulos";
    private Articulo articulo;

    //Query DB
    private static final String DELETE = "DELETE FROM "+ TABLE_NAME_DB +" WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM "+ TABLE_NAME_DB +" ORDER BY idProducto";
    private static final String FIND_BY_ID = "SELECT * FROM "+ TABLE_NAME_DB +" WHERE idProducto=";
    private static final String FIND_BY_NAME = "SELECT * FROM "+ TABLE_NAME_DB +" WHERE name=?";
    private static final String INSERT = "INSERT INTO "+ TABLE_NAME_DB +"(name, tel, passwd) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE "+ TABLE_NAME_DB +" SET name=?, tel=?, passwd=? WHERE id=?";

    @Override
    public Articulo buscarArticulo(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Articulo art = new Articulo();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_BY_ID+id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                articulo = new Articulo();
                art = result(articulo, resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
            close(preparedStatement);
        }
        return art;
    }

    @Override
    public List<Articulo> buscarSubFamilia(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Articulo> list = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String subfamilia = resultSet.getString("idSubfamilia");
                if (name.equals(subfamilia)) {
                    articulo = new Articulo();
                    list.add(result(articulo, resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
            close(preparedStatement);
        }
        return list;
    }

    @Override
    public List<Articulo> articulos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Articulo> list = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                articulo = new Articulo();
                list.add(result(articulo, resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
            close(preparedStatement);
        }
        return list;
    }

    private Articulo result(Articulo articulo, ResultSet resultSet) throws SQLException {
        articulo.setId(resultSet.getInt("idProducto"));
        articulo.setNombre(resultSet.getString("sNombre"));
        articulo.setDescripcion(resultSet.getString("desDescripcion"));
        articulo.setFamilia(resultSet.getString("idFamilia"));
        articulo.setSubFamilia(resultSet.getString("idSubfamilia"));
        articulo.setColor(resultSet.getInt("idColor"));
        articulo.setMarca(resultSet.getInt("idMarca"));
        articulo.setImagen(resultSet.getString("sImagen"));
        return articulo;
    }
}
