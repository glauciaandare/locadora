package com.locadora.dao;

import com.locadora.model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    public void addCategoria(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO CATEGORIA (COD_CAT, NOME, VALOR) VALUES (?, ?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, categoria.getCod_cat());
            preparedStatement.setString(2, categoria.getNome());
            preparedStatement.setDouble(3, categoria.getValor());
            preparedStatement.executeUpdate();
        }
    }

    public List<Categoria> getAllCategorias() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM CATEGORIA";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setCod_cat(resultSet.getInt("COD_CAT"));
                categoria.setNome(resultSet.getString("NOME"));
                categoria.setValor(resultSet.getDouble("VALOR"));
                categorias.add(categoria);
            }
        }
        return categorias;
    }

    public void updateCategoria(Categoria categoria) throws SQLException {
        String sql = "UPDATE CATEGORIA SET NOME = ?, VALOR = ? WHERE COD_CAT = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, categoria.getNome());
            preparedStatement.setDouble(2, categoria.getValor());
            preparedStatement.setInt(3, categoria.getCod_cat());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteCategoria(int codCat) throws SQLException {
        String sql = "DELETE FROM CATEGORIA WHERE COD_CAT = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, codCat);
            preparedStatement.executeUpdate();
        }
    }
}