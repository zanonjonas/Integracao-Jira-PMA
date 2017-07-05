package br.com.paxtecnologia.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relatorioBean")
public class RelatorioBean {

	/**
	 * Campos da tabela
	 * 
	 * chamado, 
	 * titulo,
	 * status, 
	 * tipo_chamado, 
	 * solicitante, 
	 * projeto, 
	 * host, 
	 * responsavel, 
	 * prioridade, 
	 * criador, 
	 * resolucao, 
	 * tipo_relacao, 
	 * relacao, 
	 * relacionadas, 
	 * tipo_parada,
	 * data_criacao, 
	 * data_fechamento, 
	 * data_atualizacao, 
	 * data_inicio_parada, 
	 * data_fim_parada,
	 * segundos
	 * 
	 */
	
	private String key;
	private FieldsBean fields;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public FieldsBean getFields() {
		return fields;
	}

	public void setFields(FieldsBean fields) {
		this.fields = fields;
	}
}
