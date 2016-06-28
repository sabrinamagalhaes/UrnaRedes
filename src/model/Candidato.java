package model;

public class Candidato implements java.io.Serializable{
	
	private int codigoVotacao;
	private String nomeCandidato;
	private String partido;
	private int numVotos;
	
	public Candidato(int codigoVotacao, String nomeCandidato, String partido, int numVotos) {
		super();
		this.codigoVotacao = codigoVotacao;
		this.nomeCandidato = nomeCandidato;
		this.partido = partido;
		this.numVotos = numVotos;
	}
	public int getCodigoVotacao() {
		return codigoVotacao;
	}
	public void setCodigoVotacao(int codigoVotacao) {
		this.codigoVotacao = codigoVotacao;
	}
	public String getNomeCandidato() {
		return nomeCandidato;
	}
	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public int getNumVotos() {
		return numVotos;
	}
	public void setNumVotos(int numVotos) {
		this.numVotos = numVotos;
	}
}
