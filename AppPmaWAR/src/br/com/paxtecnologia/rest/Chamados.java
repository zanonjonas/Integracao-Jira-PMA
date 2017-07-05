package br.com.paxtecnologia.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.paxtecnologia.oAuth.Oauth;
import br.com.paxtecnologia.processamento.Processamento;
import br.com.paxtecnologia.processamento.ProcessamentoOAuth;
import br.com.paxtecnologia.vo.RelatorioRetornoVO;

@Path("/processamento")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@RequestScoped
public class Chamados {
	@EJB
	private Processamento processamento; // Métod legado, utiliza basic auth
	
	@EJB
	private ProcessamentoOAuth processamentoOAuth;

	@EJB
	private Oauth oAuth;

	@GET
	@Path("/auth/temp_token")
	public String tempToken() {
		return oAuth.getTempToken();
	}

	@GET
	@Path("/auth/access_token/{verifier_code}")
	public String accessToken(@PathParam("verifier_code") String verifier_code) {
		return oAuth.getAccessToken(verifier_code);
	}

	@GET
	@Path("/chamados")
	public RelatorioRetornoVO relatorio(@QueryParam("data_inicial") String data_inicial,
			@QueryParam("data_final") String data_final) {
		RelatorioRetornoVO retorno = new RelatorioRetornoVO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dtIni = null;
			Date dtFim = null;
			if (data_inicial != null) {
				try {
					dtIni = sdf.parse(data_inicial);
					retorno.setData_inicio(data_inicial);
				} catch (ParseException e) {
					retorno.setData_inicio("Data fora do formato yyyy-MM-dd");
					throw new Exception("Data fora do formato yyyy-MM-dd");
				}
			} else {
				data_inicial = sdf.format(new Date());
				dtIni = sdf.parse(data_inicial);
			}

			if (data_final != null) {
				try {
					dtFim = sdf.parse(data_final);
					retorno.setData_fim(data_final);
				} catch (ParseException e) {
					retorno.setData_fim("Data fora do formato yyyy-MM-dd");
					throw new Exception("Data fora do formato yyyy-MM-dd");
				}
			} else {
				data_final = sdf.format(new Date());
				dtFim = sdf.parse(data_final);
			}

			// Se a data de inicio > data fim = {
			// - data inicio = data fim - 1 mes;
			// }

			if (dtIni.compareTo(dtFim) >= 0) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(dtFim);
				cal.add(Calendar.MONTH, -1);
				dtIni = cal.getTime();

				data_inicial = sdf.format(dtIni);
				retorno.setData_inicio(data_inicial);
			}

			retorno = processamentoOAuth.iniciaProcessamento(data_inicial, data_final);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	@GET
	@Path("/basic_auth/chamados")
	public RelatorioRetornoVO relatorioBasic(@QueryParam("data_inicial") String data_inicial,
			@QueryParam("data_final") String data_final) {
		RelatorioRetornoVO retorno = new RelatorioRetornoVO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dtIni = null;
			Date dtFim = null;
			if (data_inicial != null) {
				try {
					dtIni = sdf.parse(data_inicial);
					retorno.setData_inicio(data_inicial);
				} catch (ParseException e) {
					retorno.setData_inicio("Data fora do formato yyyy-MM-dd");
					throw new Exception("Data fora do formato yyyy-MM-dd");
				}
			} else {
				data_inicial = sdf.format(new Date());
				dtIni = sdf.parse(data_inicial);
			}

			if (data_final != null) {
				try {
					dtFim = sdf.parse(data_final);
					retorno.setData_fim(data_final);
				} catch (ParseException e) {
					retorno.setData_fim("Data fora do formato yyyy-MM-dd");
					throw new Exception("Data fora do formato yyyy-MM-dd");
				}
			} else {
				data_final = sdf.format(new Date());
				dtFim = sdf.parse(data_final);
			}

			// Se a data de inicio > data fim = {
			// - data inicio = data fim - 1 mes;
			// }

			if (dtIni.compareTo(dtFim) >= 0) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(dtFim);
				cal.add(Calendar.MONTH, -1);
				dtIni = cal.getTime();

				data_inicial = sdf.format(dtIni);
				retorno.setData_inicio(data_inicial);
			}

			retorno = processamento.iniciaProcessamento(data_inicial, data_final);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
}
