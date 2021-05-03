package br.com.stoom.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name="GAPI", url="https://maps.googleapis.com/maps/api/geocode/json")
public interface BuscarFeign {
	
	@RequestMapping("/adress={adress}+key={key}")
	public String buscarLatitudeLongitude(@PathVariable("adress") String adress, 
			@PathVariable("key") String key);

}
