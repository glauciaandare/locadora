package com.locadora.dao;

import com.locadora.model.Locacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocacaoDAO {
    public void addLocacao(Locacao locacao) throws SQLException {
        String sql = "INSERT INTO LOCACAO (COD_LOC, DATA_LOC, DESCONTO, MULTA, SUB_TOTAL, COD_CLI) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, locacao.getCad_loc());
            preparedStatement.setDate(2, new Date(locacao.getData_loc().getTime()));
            preparedStatement.setDouble(3, locacao.getDesconto());
            preparedStatement.setDouble(4, locacao.getMulta());
            preparedStatement.setDouble(5, locacao.getSub_total());
            preparedStatement.setInt(6, locacao.getCod_cli());
            preparedStatement.executeUpdate();
        }
    }

    public List<Locacao> getAllLocacoes() throws SQLException {
        List<Locacao> locacoes = new ArrayList<>();
        String sql = "SELECT * FROM LOCACAO";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Locacao locacao = new Locacao();
                locacao.setCad_loc(resultSet.getInt("COD_LOC"));
                locacao.setData_loc(resultSet.getDate("DATA_LOC"));
                locacao.setDesconto(resultSet.getDouble("DESCONTO"));
                locacao.setMulta(resultSet.getDouble("MULTA"));
                locacao.setSub_total(resultSet.getDouble("SUB_TOTAL"));
                locacao.setCod_cli(resultSet.getInt("COD_CLI"));
                locacoes.add(locacao);
            }
        }
        return locacoes;
    }

    public void updateLocacao(Locacao locacao) throws SQLException {
        String sql = "UPDATE LOCACAO SET DATA_LOC = ?, DESCONTO = ?, MULTA = ?, SUB_TOTAL = ?, COD_CLI = ? WHERE COD_LOC = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, new Date(locacao.getData_loc().getTime()));
            preparedStatement.setDouble(2, locacao.getDesconto());
            preparedStatement.setDouble(3, locacao.getMulta());
            preparedStatement.setDouble(4, locacao.getSub_total());
            preparedStatement.setInt(5, locacao.getCod_cli());
            preparedStatement.setInt(6, locacao.getCad_loc());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteLocacao(int codLoc) throws SQLException {
        String sql = "DELETE FROM LOCACAO WHERE COD_LOC = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, codLoc);
            preparedStatement.executeUpdate();
        }
    }
}
