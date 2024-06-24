package com.locadora.dao;

import com.locadora.model.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
    public void addFilme(Filme filme) throws SQLException {
        String sql = "INSERT INTO FILMES (COD_FILME, TITULO_ORIGINAL, TITULO, QUANTIDADE, COD_CAT, COD_GEN) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, filme.getCod_filme());
            preparedStatement.setString(2, filme.getTitulo_original());
            preparedStatement.setString(3, filme.getTitulo());
            preparedStatement.setInt(4, filme.getQuantidade());
            preparedStatement.setInt(5, filme.getCod_cat());
            preparedStatement.setInt(6, filme.getCod_gen());
            preparedStatement.executeUpdate();
        }
    }

    public List<Filme> getAllFilmes() throws SQLException {
        List<Filme> filmes = new ArrayList<>();
        String sql = "SELECT * FROM FILMES";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Filme filme = new Filme();
                filme.setCod_filme(resultSet.getInt("COD_FILME"));
                filme.setTitulo_original(resultSet.getString("TITULO_ORIGINAL"));
                filme.setTitulo(resultSet.getString("TITULO"));
                filme.setQuantidade(resultSet.getInt("QUANTIDADE"));
                filme.setCod_cat(resultSet.getInt("COD_CAT"));
                filme.setCod_gen(resultSet.getInt("COD_GEN"));
                filmes.add(filme);
            }
        }
        return filmes;
    }

    public void updateFilme(Filme filme) throws SQLException {
        String sql = "UPDATE FILMES SET TITULO_ORIGINAL = ?, TITULO = ?, QUANTIDADE = ?, COD_CAT = ?, COD_GEN = ? WHERE COD_FILME = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, filme.getTitulo_original());
            preparedStatement.setString(2, filme.getTitulo());
            preparedStatement.setInt(3, filme.getQuantidade());
            preparedStatement.setInt(4, filme.getCod_cat());
            preparedStatement.setInt(5, filme.getCod_gen());
            preparedStatement.setInt(6, filme.getCod_filme());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteFilme(int codFilme) throws SQLException {
        String sql = "DELETE FROM FILMES WHERE COD_FILME = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, codFilme);
            preparedStatement.executeUpdate();
        }
    }
}
