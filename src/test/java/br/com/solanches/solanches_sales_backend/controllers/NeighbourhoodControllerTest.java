package br.com.solanches.solanches_sales_backend.controllers;

import br.com.solanches.solanches_sales_backend.entities.Neighbourhood;
import br.com.solanches.solanches_sales_backend.services.NeighbourhoodService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NeighbourhoodController.class)
@AutoConfigureMockMvc
class NeighbourhoodControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NeighbourhoodService neighbourhoodService;

    @Test
    public void shouldReturnListOfNeighbourhoods() throws Exception {
        List<Neighbourhood> neighbourhoods = List.of(
                new Neighbourhood(1, "Downtown", BigDecimal.valueOf(5.0))
        );

        when(neighbourhoodService.findAll()).thenReturn(neighbourhoods);

        mockMvc.perform(get("/neighbourhoods")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:1,name:'Downtown',deliveryPrice:5.0}]"));
    }
}
