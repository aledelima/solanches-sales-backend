package br.com.solanches.solanches_sales_backend.controllers;

import br.com.solanches.solanches_sales_backend.entities.Neighbourhood;
import br.com.solanches.solanches_sales_backend.services.NeighbourhoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class NeighbourhoodController {

    private final NeighbourhoodService neighbourhoodService;

    @GetMapping("/neighbourhoods")
    public ResponseEntity<List<Neighbourhood>> findAll() {
        return ResponseEntity.ok().body(neighbourhoodService.findAll());
    }

}
