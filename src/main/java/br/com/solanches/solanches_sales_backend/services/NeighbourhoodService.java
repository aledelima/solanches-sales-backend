package br.com.solanches.solanches_sales_backend.services;

import br.com.solanches.solanches_sales_backend.entities.Neighbourhood;
import br.com.solanches.solanches_sales_backend.repositories.NeighbourhoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class NeighbourhoodService {

    private NeighbourhoodRepository neighbourhoodRepository;

    public List<Neighbourhood> findAll() {
        return neighbourhoodRepository.findAll();
    }
}
