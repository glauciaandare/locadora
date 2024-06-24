package com.locadora.dao;

import com.locadora.model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {
    public void addGenero(Genero genero) throws SQLException {
        String sql = "INSERT INTO GENERO (COD_GEN, NOME) VALUES (?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, genero.getCod_gen());
            preparedStatement.setString(2, genero.getNome());
            preparedStatement.executeUpdate();
        }
    }

    public List<Genero> getAllGeneros() throws SQLException {
        List<Genero> generos = new ArrayList<>();
        String sql = "SELECT * FROM GENERO";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Genero genero = new Genero();
                genero.setCod_gen(resultSet.getInt("COD_GEN"));
                genero.setNome(resultSet.getString("NOME"));
                generos.add(genero);
            }
        }
        return generos;
    }

    public void updateGenero(Genero genero) throws SQLException {
        String sql = "UPDATE GENERO SET NOME = ? WHERE COD_GEN = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, genero.getNome());
            preparedStatement.setInt(2, genero.getCod_gen());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteGenero(int codGen) throws SQLException {
        String sql = "DELETE FROM GENERO WHERE COD_GEN = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, codGen);
            preparedStatement.executeUpdate();
        }
    }
}
