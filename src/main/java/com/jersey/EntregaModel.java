package com.jersey;

public class EntregaModel {
	private int id;
	private String recebedorNome;
	private String recebedorCpf;
	private String numPedido;
	private String clientId;
	private String entregaData;
	
	
	public String getNumPedido() {
		return numPedido;
	}
	public void setNumPedido(String numPedido) {
		this.numPedido = numPedido;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRecebedorNome() {
		return recebedorNome;
	}
	public void setRecebedorNome(String recebedorNome) {
		this.recebedorNome = recebedorNome;
	}
	public String getRecebedorCpf() {
		return recebedorCpf;
	}
	public void setRecebedorCpf(String recebedorCpf) {
		this.recebedorCpf = recebedorCpf;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getEntregaData() {
		return entregaData;
	}
	public void setEntregaData(String entregaData) {
		this.entregaData = entregaData;
	}
}
