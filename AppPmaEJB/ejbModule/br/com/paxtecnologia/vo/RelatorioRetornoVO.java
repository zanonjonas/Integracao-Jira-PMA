package br.com.paxtecnologia.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relatorioRetornoVO")
public class RelatorioRetornoVO {
	@XmlElement(name = "Numero de chamados processados")
	private Integer numeroDeChamadosProcessados = 0;

	@XmlElement(name = "Numero de chamados com erro")
	private Integer numeroDeChamadoComErro = 0;

	@XmlElement(name = "data_inicial")
	private String data_inicio;

	@XmlElement(name = "data_final")
	private String data_fim;

	@XmlElement(name = "errors")
	private List<String> errors = new ArrayList<>();

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public Integer getNumeroDeChamadosProcessados() {
		return numeroDeChamadosProcessados;
	}

	public void setNumeroDeChamadosProcessados(Integer numeroDeChamadosProcessados) {
		this.numeroDeChamadosProcessados = numeroDeChamadosProcessados;
	}

	public Integer getNumeroDeChamadoComErro() {
		return numeroDeChamadoComErro;
	}

	public void setNumeroDeChamadoComErro(Integer numeroDeChamadoComErro) {
		this.numeroDeChamadoComErro = numeroDeChamadoComErro;
	}

	public String getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}

	public String getData_fim() {
		return data_fim;
	}

	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}

}
