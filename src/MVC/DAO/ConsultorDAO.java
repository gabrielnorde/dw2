package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Consultor;

public class ConsultorDAO {
    	public void inserir(Consultor b) {
		String sql = "INSERT INTO Consultor( CPF, nome, email, rua, numero, bairro, cidade, estado  VALUES (?,?,?,?, ?,?,?,?);";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, b.getCPF());
			stmt.setString(2,b.getNome());
			stmt.setString(3, b.getEmail());
			stmt.setString(4, b.getRua());
            stmt.setString(5, b.getNumero());
            stmt.setString(6, b.getBairro());
            stmt.setString(7, b.getCidade());
            stmt.setString(8, b.getEstado());
			
			stmt.execute();
			stmt.close();
		}catch( SQLException e) {
			e.printStackTrace();
		};
	}
	
	public void update(Consultor b) {
		String sql = "UPDATE Consultor SET CPF = ?, nome = ?, email = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, estado = ? WHERE idConsultor =?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, b.getCPF());
			stmt.setString(2,b.getNome());
			stmt.setString(3, b.getEmail());
			stmt.setString(4, b.getRua());
            stmt.setString(5, b.getNumero());
            stmt.setString(6, b.getBairro());
            stmt.setString(7, b.getCidade());
            stmt.setString(8, b.getEstado());
			
			stmt.execute();
			stmt.close();
		}catch( SQLException e) {
			e.printStackTrace();
		};
	}
	
	public List<Consultor> get() {
		List<Consultor> consultores = new ArrayList<Consultor>();
		
		try {
			String sql = "SELECT * FROM Consultor";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Consultor consultor = new Consultor();
				consultor.setCodigo(rs.getInt("idConsultor"));
				consultor.setCPF(rs.getString("CPF"));
				consultor.setEmail(rs.getString("email"));
				consultor.setNome(rs.getString("nome"));
                consultor.setRua(rs.getString("rua"));
                consultor.setNumero(rs.getString("numero"));
                consultor.setBairro(rs.getString("bairro"));
                consultor.setEstado(rs.getString("estado"));
				consultores.add(consultor);
			}
			stmt.close();
		}catch( SQLException e) {
			e.printStackTrace();
		};
		return bolsistas;
		}
	
	public void remove(Consultor b) {
		String sql = "DELETE FROM Consultor WHERE idConsultor = ?;";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, b.getCodigo());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
