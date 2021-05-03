package br.com.stoom.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.stoom.model.Endereco;
import br.com.stoom.service.impl.EnderecoServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EnderecoController.class)
class EnderecoControllerTest {

    @MockBean
    private EnderecoServiceImpl service;
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    HttpMessageNotWritableException httpMessageNotWritableException;


    @Test
    void salvar() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/salvar")
                .content(mapper.writeValueAsString(getEndereco()))
                .contentType(MediaType.APPLICATION_JSON);
        mvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().is(200));
        Mockito.verify(service, Mockito.times(1)).salvar(Mockito.any());
    }

    @Test
    void salvar_MethodArgumentNotValidException() throws Exception {
        Endereco endereco = getEndereco();
        endereco.setComplement(null);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/salvar")
                .content(mapper.writeValueAsString(endereco))
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().is(400)).andReturn();
        Assertions.assertTrue(result.getResponse().getContentAsString().contains("complement nao pode ser vazio"));
    }

    @Test
    void atualizar() throws Exception {
        Endereco endereco = getEndereco();
        endereco.setId(1L);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/atualizar")
                .content(mapper.writeValueAsString(endereco))
                .contentType(MediaType.APPLICATION_JSON);
        mvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().is(200));
        Mockito.verify(service, Mockito.times(1)).salvar(endereco);
    }

    @Test
    void buscarTodos() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/todos");
        mvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().is(200));
        Mockito.verify(service,Mockito.times(1)).buscarTodos();
    }

    @Test
    void buscarPorId() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/endereco/1");
        mvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().is(200));
        Mockito.verify(service,Mockito.times(1)).buscarPorId(1L);
    }

    @Test
    void deletarPorId() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deletar/1");
        mvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().is(200));
        Mockito.verify(service,Mockito.times(1)).deletarPorId(1L);
    }

    @Test
    void deletarPorId_HttpMessageNotWritableException() throws Exception {
        Mockito.doThrow(httpMessageNotWritableException).when(service).deletarPorId(1L);
        Mockito.when(httpMessageNotWritableException.getLocalizedMessage()).thenReturn("my localized Message");
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deletar/1");
        mvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().is(400));
        Mockito.verify(service,Mockito.times(1)).deletarPorId(1L);
    }

    private Endereco getEndereco() {
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setCity("City");
        endereco.setComplement("Complement");
        endereco.setCountry("Country");
        endereco.setLatitude("Latitude");
        endereco.setLongitude("Longitude");
        endereco.setState("State");
        endereco.setNeighbourhood("Neighbourhood");
        endereco.setNumber(123);
        endereco.setStreetName("StreetName");
        endereco.setZipcode("ZipCode");
        return endereco;
    }
}