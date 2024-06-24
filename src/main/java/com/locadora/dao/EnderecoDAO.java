package com.locadora.dao;

import com.locadora.model.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {
    public void addEndereco(Endereco endereco) throws SQLException {
        String sql = "INSERT INTO ENDERECO (COD_END, LOGRADOURO, TIPO_LOG, COMPLEMENTO, CIDADE, UF, CEP, NUMERO, BAIRRO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, endereco.getCod_end());
            preparedStatement.setString(2, endereco.getLogradouro());
            preparedStatement.setString(3, endereco.getTipo_log());
            preparedStatement.setString(4, endereco.getComplemento());
            preparedStatement.setString(5, endereco.getCidade());
            preparedStatement.setString(6, String.valueOf(endereco.getUf()));
            preparedStatement.setString(7, endereco.getCep());
            preparedStatement.setString(8, endereco.getNumero());
            preparedStatement.setString(9, endereco.getBairro());
            preparedStatement.executeUpdate();
        }
    }

    public List<Endereco> getAllEnderecos() throws SQLException {
        List<Endereco> enderecos = new ArrayList<>();
        String sql = "SELECT * FROM ENDERECO";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Endereco endereco = new Endereco();
                endereco.setCod_end(resultSet.getInt("COD_END"));
                endereco.setLogradouro(resultSet.getString("LOGRADOURO"));
                endereco.setTipo_log(resultSet.getString("TIPO_LOG"));
                endereco.setComplemento(resultSet.getString("COMPLEMENTO"));
                endereco.setCidade(resultSet.getString("CIDADE"));
                endereco.setUf(resultSet.getString("UF").charAt(0));
                endereco.setCep(resultSet.getString("CEP"));
                endereco.setNumero(resultSet.getString("NUMERO"));
                endereco.setBairro(resultSet.getString("BAIRRO"));
                enderecos.add(endereco);
            }
        }
        return enderecos;
    }

    public void updateEndereco(Endereco endereco) throws SQLException {
        String sql = "UPDATE ENDERECO SET LOGRADOURO = ?, TIPO_LOG = ?, COMPLEMENTO = ?, CIDADE = ?, UF = ?, CEP = ?, NUMERO = ?, BAIRRO = ? WHERE COD_END = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, endereco.getLogradouro());
            preparedStatement.setString(2, endereco.getTipo_log());
            preparedStatement.setString(3, endereco.getComplemento());
            preparedStatement.setString(4, endereco.getCidade());
            preparedStatement.setString(5, String.valueOf(endereco.getUf()));
            preparedStatement.setString(6, endereco.getCep());
            preparedStatement.setString(7, endereco.getNumero());
            preparedStatement.setString(8, endereco.getBairro());
            preparedStatement.setInt(9, endereco.getCod_end());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteEndereco(int codEnd) throws SQLException {
        String sql = "DELETE FROM ENDERECO WHERE COD_END = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, codEnd);
            preparedStatement.executeUpdate();
        }
    }
}
