package com.mercadolibre.challenge.infraestructure.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.challenge.application.usescases.SaveDna;
import com.mercadolibre.challenge.application.usescases.StatsDna;
import com.mercadolibre.challenge.infraestructure.rest.dto.RequestDna;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class AdnControllerTest {

    @Mock
    private WebApplicationContext wac;

    @InjectMocks
    private AdnController ac;

    private MockMvc mockMvc;

    @Mock
    private SaveDna saveDna;

    @Mock
    private StatsDna statsDna;

    @BeforeEach
    void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
    }

    @Test
    void mutant() throws Exception {
        String[] chains = new String[]{
                "ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"
        };
        RequestDna dna = new RequestDna(chains);
        Mockito.when(saveDna.execute(chains)).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/mutant")
                .content(asJsonString(dna))
                .characterEncoding("utf-8")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void stats() throws Exception {
        Mockito.doNothing().when(statsDna).execute();
        Mockito.when(statsDna.getCountHuman()).thenReturn(0);
        Mockito.when(statsDna.getCountMutant()).thenReturn(0);
        Mockito.when(statsDna.getRatio()).thenReturn(0.0);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/stats")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void human() throws Exception {
        String[] chains = new String[]{
                "ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"
        };
        RequestDna dna = new RequestDna(chains);
        Mockito.when(saveDna.execute(chains)).thenReturn(false);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/mutant")
                        .content(asJsonString(dna))
                        .characterEncoding("utf-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}