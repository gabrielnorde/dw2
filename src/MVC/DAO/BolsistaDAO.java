package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Bolsista;

public class BolsistaDAO {
private Connection connection;
	
	public void inserir(Bolsista b) {
		String sql = "INSERT INTO Bolsista( CPF, nome, curso  VALUES (?,?,?);";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, b.getCPF());
			stmt.setString(2,b.getNome());
			stmt.setString(3, b.getCurso());
			
			
			stmt.execute();
			stmt.close();
		}catch( SQLException e) {
			e.printStackTrace();
		};
	}
	
	public void update(Bolsista b) {
		String sql = "UPDATE Bolsista SET CPF = ?, nome = ?, curso = ? WHERE idBolsista =?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, b.getCPF());
			stmt.setString(2,b.getNome());
			stmt.setString(3, b.getCurso());
			stmt.setInt(4, b.getCodigo());
			
			stmt.execute();
			stmt.close();
		}catch( SQLException e) {
			e.printStackTrace();
		};
	}
	
	public List<Bolsista> get() {
		List<Bolsista> bolsistas = new ArrayList<Bolsista>();
		
		try {
			String sql = "SELECT * FROM Bolsista";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Bolsista bolsista = new Bolsista();
				bolsista.setCodigo(rs.getInt("idBolsista"));
				bolsista.setCPF(rs.getString("CPF"));
				bolsista.setCurso(rs.getString("curso"));
				bolsista.setNome(rs.getString("nome"));
				bolsistas.add(bolsista);
			}
			stmt.close();
		}catch( SQLException e) {
			e.printStackTrace();
		};
		return bolsistas;
		}
	
	public void remove(Bolsista b) {
		String sql = "DELETE FROM Bolsista WHERE idBolsista = ?;";
		
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
