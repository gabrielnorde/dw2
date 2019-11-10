package MVC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MVC.Modelo.Coordenador;
import MVC.Utils.ConnectionLojaFactory;

public class CoordenadorDAO {
	public void inserir(Coordenador b) {
		String sql = "INSERT INTO Coordenador( CPF, nome, email, rua, numero, bairro, cidade, estado  VALUES (?,?,?,?, ?,?,?,?);";
		Connection connection = null;
		PreparedStatement ps = null;
		connection = ConnectionLojaFactory.getConnection();
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
	
	public void update(Coordenador b) {
		String sql = "UPDATE Coordenador SET CPF = ?, nome = ?, email = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, estado = ? WHERE idCoordenador =?";
		Connection connection = null;
		PreparedStatement ps = null;
		connection = ConnectionLojaFactory.getConnection();
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
	
	public static List<Coordenador> get() {
		List<Coordenador> coordenadores = new ArrayList<Coordenador>();
		Connection connection = null;
		PreparedStatement ps = null;
		connection = ConnectionLojaFactory.getConnection();
		try {
			String sql = "SELECT * FROM Coordenador";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Coordenador coordenador = new Coordenador();
				coordenador.setCodigo(rs.getInt("idCoordenador"));
				coordenador.setCPF(rs.getString("CPF"));
				coordenador.setEmail(rs.getString("email"));
				coordenador.setNome(rs.getString("nome"));
                coordenador.setRua(rs.getString("rua"));
                coordenador.setNumero(rs.getString("numero"));
                coordenador.setBairro(rs.getString("bairro"));
                coordenador.setEstado(rs.getString("estado"));
				coordenadores.add(coordenador);
			}
			stmt.close();
		}catch( SQLException e) {
			e.printStackTrace();
		};
			return coordenadores;
		}
	
	public void remove(Coordenador b) {
		String sql = "DELETE FROM Coordenador WHERE idCoordenador = ?;";
		Connection connection = null;
		PreparedStatement ps = null;
		connection = ConnectionLojaFactory.getConnection();
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
