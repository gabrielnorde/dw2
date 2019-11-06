package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Usuario;

public class UsuarioDAO {

    private Connection connection;
	
	public void inserir(Usuario b) {
		String sql = "INSERT INTO Usuario( nivel, username, senha  VALUES (?,?,?);";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, b.getnivel());
			stmt.setString(2,b.getUsername());
			stmt.setString(3, b.getSenha());
			
			
			stmt.execute();
			stmt.close();
		}catch( SQLException e) {
			e.printStackTrace();
		};
	}
	
	public void update(Usuario b) {
		String sql = "UPDATE Usuario SET nivel = ?, username = ?, senha = ? WHERE idUsuario =?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, b.getNivel());
			stmt.setString(2,b.getUsername());
			stmt.setString(3, b.getSenha());
			stmt.setInt(4, b.getCodigo());
			
			stmt.execute();
			stmt.close();
		}catch( SQLException e) {
			e.printStackTrace();
		};
	}
	
	public List<Usuario> get() {
		List<Usuario> bolsistas = new ArrayList<Usuario>();
		
		try {
			String sql = "SELECT * FROM Usuario";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Usuario bolsista = new Usuario();
				bolsista.setCodigo(rs.getInt("idUsuario"));
				bolsista.setNivel(rs.getString("nivel"));
				bolsista.setSenha(rs.getString("senha"));
				bolsista.setUsername(rs.getString("username"));
				bolsistas.add(bolsista);
			}
			stmt.close();
		}catch( SQLException e) {
			e.printStackTrace();
		};
		return bolsistas;
		}
	
	public void remove(Usuario b) {
		String sql = "DELETE FROM Usuario WHERE idUsuario = ?;";
		
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
