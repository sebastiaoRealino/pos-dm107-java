package com.jersey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
	public void insert(Connection conn, ContatoModel contato) throws SQLException{
		String sql = "insert into contato (nome, email, cel) values (?, ?, ?);";
		PreparedStatement pstm;
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, contato.getName());
			pstm.setString(2, contato.getEmail());
			pstm.setString(3, contato.getCel());
			pstm.execute();
	}
	
	public void update(Connection conn, ContatoModel contato, int contatoId) throws SQLException{
		String sql = "update contato set nome  = ?,  email = ?,  cel = ? where id = ?";
		PreparedStatement pstm;
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, contato.getName());
			pstm.setString(2, contato.getEmail());
			pstm.setString(3, contato.getCel());
			pstm.setInt(4, contatoId);
			pstm.execute();
	}
	
	public List<ContatoModel> list(Connection conn) throws SQLException{
		String sql = "select * from contato";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			ContatoModel contato;
			List<ContatoModel> contatos = new ArrayList<>();
			 while (rs.next())
		      {
		        int id = rs.getInt("id");
		        String name = rs.getString("nome");
		        String email = rs.getString("email");
				String cel = rs.getString("cel");
		        contato = new ContatoModel(id, name, cel, email );
		        contatos.add(contato);
		      }
		return contatos;
	}
	
	public ContatoModel listById(Connection conn, int contatoId) throws SQLException{
		String sql = "select * from contato where id = ?";
			PreparedStatement pstm;
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, contatoId);
			
			ResultSet rs = pstm.executeQuery();
			ContatoModel contato  = new ContatoModel();
			 while (rs.next())
		      {
		        int id = rs.getInt("id");
		        String name = rs.getString("nome");
		        String email = rs.getString("email");
				String cel = rs.getString("cel");
				contato = new ContatoModel(id, name, cel, email );
		      }
		return contato;
	}
	
	public ContatoModel listByNameEmail(Connection conn, String contatoName, String contatoEmail) throws SQLException{
		String sql = "select * from contato where nome = ?";
		
			if(contatoEmail != null){
				sql += " and email = ?";
			}
			
			PreparedStatement pstm;
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, contatoName);
			
			if(contatoEmail != null){
				pstm.setString(2, contatoEmail);
			}
			
			ResultSet rs = pstm.executeQuery();
			ContatoModel contato  = new ContatoModel();
			 while (rs.next())
		      {
		        int id = rs.getInt("id");
		        String name = rs.getString("nome");
		        String email = rs.getString("email");
				String cel = rs.getString("cel");
				contato = new ContatoModel(id, name, cel, email );
		      }
		return contato;
	}
	
	public  void delete(Connection conn, int contatoId) throws SQLException{
		PreparedStatement ps;
			 ps = conn.prepareStatement("delete from contato where id = ?");
			 ps.setInt(1, contatoId);
		     ps.executeUpdate();
       
	}
}
