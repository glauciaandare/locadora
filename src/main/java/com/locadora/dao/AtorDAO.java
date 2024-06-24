package com.locadora.dao;

import com.locadora.model.Ator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtorDAO {
    public void addAtor(Ator ator) throws SQLException {
        String sql = "INSERT INTO ATOR (COD_ATOR, NOME) VALUES (?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, ator.getCod_ator());
            preparedStatement.setString(2, ator.getNome());
            preparedStatement.executeUpdate();
        }
    }

    public List<Ator> getAllAtores() throws SQLException {
        List<Ator> atores = new ArrayList<>();
        String sql = "SELECT * FROM ATOR";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Ator ator = new Ator();
                ator.setCod_ator(resultSet.getInt("COD_ATOR"));
                ator.setNome(resultSet.getString("NOME"));
                atores.add(ator);
            }
        }
        return atores;
    }

    public void updateAtor(Ator ator) throws SQLException {
        String sql = "UPDATE ATOR SET NOME = ? WHERE COD_ATOR = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, ator.getNome());
            preparedStatement.setInt(2, ator.getCod_ator());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteAtor(int codAtor) throws SQLException {
        String sql = "DELETE FROM ATOR WHERE COD_ATOR = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, codAtor);
            preparedStatement.executeUpdate();
        }
    }
}
