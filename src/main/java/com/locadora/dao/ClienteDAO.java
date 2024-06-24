package com.locadora.dao;

import com.locadora.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void addCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO CLIENTE (COD_CLI, CPF, NOME, TELEFONE, COD_PROF) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, cliente.getCod_cli());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getNome());
            preparedStatement.setString(4, cliente.getTelefone());
            preparedStatement.setInt(5, cliente.getCod_prof());
            preparedStatement.executeUpdate();
        }
    }

    public List<Cliente> getAllClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTE";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setCod_cli(resultSet.getInt("COD_CLI"));
                cliente.setCpf(resultSet.getString("CPF"));
                cliente.setNome(resultSet.getString("NOME"));
                cliente.setTelefone(resultSet.getString("TELEFONE"));
                cliente.setCod_prof(resultSet.getInt("COD_PROF"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public void updateCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE CLIENTE SET CPF = ?, NOME = ?, TELEFONE = ?, COD_PROF = ? WHERE COD_CLI = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cliente.getCpf());
            preparedStatement.setString(2, cliente.getNome());
            preparedStatement.setString(3, cliente.getTelefone());
            preparedStatement.setInt(4, cliente.getCod_prof());
            preparedStatement.setInt(5, cliente.getCod_cli());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteCliente(int codCli) throws SQLException {
        String sql = "DELETE FROM CLIENTE WHERE COD_CLI = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, codCli);
            preparedStatement.executeUpdate();
        }
    }
}
