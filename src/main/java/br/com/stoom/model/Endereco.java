package br.com.stoom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Endereco {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message =  "street name nao pode ser vazio")
	@Column( name = "street_name")
	private String streetName;
	
	@NotNull(message =  "number nao pode ser vazio")
	@Column(name = "number")
	private Integer number;
	
	@NotBlank(message =  "complement nao pode ser vazio")
	@Column(name = "complement")
	private String complement;
	
	@NotBlank(message =  "neighbourhood nao pode ser vazio")
	@Column(name = "neighbourhood")
	private String neighbourhood;
	
	@NotBlank(message =  "city nao pode ser vazio")
	@Column(name = "city")
	private String city;
	
	@NotBlank(message =  "state nao pode ser vazio")
	@Column(name = "state")
	private String state;
	
	@NotBlank(message =  "country nao pode ser vazio")
	@Column(name = "country")
	private String country;
	
	@NotBlank(message =  "zip code nao pode ser vazio")
	@Column(name = "zip_code")
	private String zipcode;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;

}
