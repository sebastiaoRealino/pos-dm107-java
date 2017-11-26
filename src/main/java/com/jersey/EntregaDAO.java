package com.jersey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EntregaDAO {
	public void insert(Connection conn, EntregaModel entrega) throws SQLException {
		String sql = "insert into entrega (recebedor_nome, num_pedido, recebedor_cpf, client_id, data_entrega) values (?, ?, ?, ?, ?);";
		PreparedStatement pstm;
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, entrega.getRecebedorNome());
		pstm.setString(2, entrega.getNumPedido());
		pstm.setString(3, entrega.getRecebedorCpf());
		pstm.setString(4, entrega.getClientId());
		pstm.setString(5, entrega.getEntregaData());

		pstm.execute();
	}

	public EntregaModel listById(Connection conn, int entregaId) throws SQLException {
		String sql = "select * from entrega where id = ?";
		PreparedStatement pstm;
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, entregaId);

		ResultSet rs = pstm.executeQuery();
		EntregaModel entrega = new EntregaModel();

		while (rs.next()) {
			entrega.setId(rs.getInt("id"));
			entrega.setRecebedorNome("recebedor_nome");
			entrega.setNumPedido(rs.getString("num_pedido"));
			entrega.setRecebedorCpf(rs.getString("recebedor_cpf"));
			entrega.setClientId(rs.getString("client_id"));
			entrega.setEntregaData(rs.getString("data_entrega"));

		}
		return entrega;
	}
	public EntregaModel listByNumPedido(Connection conn, int numPedido) throws SQLException {
		String sql = "select * from entrega where num_pedido = ?";
		PreparedStatement pstm;
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, numPedido);

		ResultSet rs = pstm.executeQuery();
		EntregaModel entrega = new EntregaModel();

		while (rs.next()) {
			entrega.setId(rs.getInt("id"));
			entrega.setRecebedorNome("recebedor_nome");
			entrega.setNumPedido(rs.getString("num_pedido"));
			entrega.setRecebedorCpf(rs.getString("recebedor_cpf"));
			entrega.setClientId(rs.getString("client_id"));
			entrega.setEntregaData(rs.getString("data_entrega"));

		}
		return entrega;
	}	

	public List<EntregaModel> list(Connection conn) throws SQLException {
		String sql = "select * from entrega";
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		List<EntregaModel> entregas = new ArrayList<>();
		EntregaModel entrega;
		while (rs.next()) {
			entrega = new EntregaModel();
			entrega.setId(rs.getInt("id"));
			entrega.setRecebedorNome(rs.getString("recebedor_nome"));
			entrega.setNumPedido(rs.getString("num_pedido"));
			entrega.setRecebedorCpf(rs.getString("recebedor_cpf"));
			entrega.setClientId(rs.getString("client_id"));
			entrega.setEntregaData(rs.getString("data_entrega"));
			entregas.add(entrega);
		}
//		entrega = new EntregaModel();
//		entrega.setId(1);
//		entrega.setRecebedorNome("recebedor_nome");
//		entrega.setNumPedido(5);
//		entrega.setRecebedorCpf("recebedor_cpf");
//		entrega.setClientId(6);
//		entrega.setEntregaData("data_entrega");
//		entregas.add(entrega);
		return entregas;
	}
}
