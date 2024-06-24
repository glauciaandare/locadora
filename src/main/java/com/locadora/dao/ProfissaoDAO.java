package com.locadora.dao;

import com.locadora.model.Profissao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfissaoDAO {
    public void addProfissao(Profissao profissao) throws SQLException {
        String sql = "INSERT INTO PROFISSAO (COD_PROF, NOME) VALUES (?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, profissao.getCod_prof());
            preparedStatement.setString(2, profissao.getNome());
            preparedStatement.executeUpdate();
        }
    }

    public List<Profissao> getAllProfissoes() throws SQLException {
        List<Profissao> profissoes = new ArrayList<>();
        String sql = "SELECT * FROM PROFISSAO";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Profissao profissao = new Profissao();
                profissao.setCod_prof(resultSet.getInt("COD_PROF"));
                profissao.setNome(resultSet.getString("NOME"));
                profissoes.add(profissao);
            }
        }
        return profissoes;
    }

    public void updateProfissao(Profissao profissao) throws SQLException {
        String sql = "UPDATE PROFISSAO SET NOME = ? WHERE COD_PROF = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, profissao.getNome());
            preparedStatement.setInt(2, profissao.getCod_prof());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteProfissao(int codProf) throws SQLException {
        String sql = "DELETE FROM PROFISSAO WHERE COD_PROF = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, codProf);
            preparedStatement.executeUpdate();
        }
    }
}
