package com.locadora.dao;

import com.locadora.model.Dependente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DependenteDAO {
    public void addDependente(Dependente dependente) throws SQLException {
        String sql = "INSERT INTO DEPENDENTE (COD_CLI, COD_DEP, PARENTESCO) VALUES (?, ?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, dependente.getCod_cli());
            preparedStatement.setInt(2, dependente.getCod_dep());
            preparedStatement.setString(3, dependente.getParentesco());
            preparedStatement.executeUpdate();
        }
    }

    public List<Dependente> getAllDependentes() throws SQLException {
        List<Dependente> dependentes = new ArrayList<>();
        String sql = "SELECT * FROM DEPENDENTE";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Dependente dependente = new Dependente();
                dependente.setCod_cli(resultSet.getInt("COD_CLI"));
                dependente.setCod_dep(resultSet.getInt("COD_DEP"));
                dependente.setParentesco(resultSet.getString("PARENTESCO"));
                dependentes.add(dependente);
            }
        }
        return dependentes;
    }

    public void updateDependente(Dependente dependente) throws SQLException {
        String sql = "UPDATE DEPENDENTE SET PARENTESCO = ? WHERE COD_CLI = ? AND COD_DEP = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, dependente.getParentesco());
            preparedStatement.setInt(2, dependente.getCod_cli());
            preparedStatement.setInt(3, dependente.getCod_dep());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteDependente(int codCli, int codDep) throws SQLException {
        String sql = "DELETE FROM DEPENDENTE WHERE COD_CLI = ? AND COD_DEP = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, codCli);
            preparedStatement.setInt(2, codDep);
            preparedStatement.executeUpdate();
        }
    }
}
