package br.com.stoom.localizador;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stoom.feign.BuscarFeign;
import br.com.stoom.model.Endereco;

@Service
public class LocalizadorImpl implements Localizador {

	
	@Autowired
	private BuscarFeign feign;
	
	
	private String key = "AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw";
	
	@Override
	public void buscarInformacoes(Endereco endereco) {
		@SuppressWarnings("deprecation")
		String adress = URLEncoder.encode(endereco.getStreetName()+" "+endereco.getNumber()+" "+
				endereco.getCity()+" "+endereco.getState()+" "+endereco.getCountry());
		this.feign.buscarLatitudeLongitude(adress, key);
		
	}
}
