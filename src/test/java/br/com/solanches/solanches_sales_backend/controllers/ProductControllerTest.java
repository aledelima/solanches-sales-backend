package br.com.solanches.solanches_sales_backend.controllers;

import br.com.solanches.solanches_sales_backend.entities.Product;
import br.com.solanches.solanches_sales_backend.entities.enums.ProductType;
import br.com.solanches.solanches_sales_backend.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;  // Mocking ProductService

    @Test
    public void shouldReturnListOfProducts() throws Exception {
        // Mocked data for the test
        List<Product> products = List.of(
                new Product(1, 1, "Product 1", ProductType.SANDWICH, BigDecimal.valueOf(10), "Unit", new ArrayList<>())
        );

        // Mock behavior for the ProductService
        when(productService.findAll()).thenReturn(products);

        // Perform the GET request and validate response
        mockMvc.perform(get("/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:1,name:'Product 1'}]"));
    }
}
