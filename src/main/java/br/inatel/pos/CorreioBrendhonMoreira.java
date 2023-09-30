package br.inatel.pos;

import java.rmi.RemoteException;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteProxy;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;

public class CorreioBrendhonMoreira {
	public String calculaEndereco(String cep) {
		// Init Proxy
		final AtendeClienteProxy proxy = new AtendeClienteProxy();
		
		// Init endereco
		EnderecoERP endereco = null;
		try {
			// Fetch endereco
			endereco = proxy.consultaCEP(cep);

			// Get endereco data
			final String cidade = endereco.getCidade();
			final String rua = endereco.getEnd();
			final String bairro = endereco.getBairro();

			// Return endereco
			return "Endereço completo " +  rua + "  " +  bairro + "  " + cidade;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return "";
	}
}
