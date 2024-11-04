package br.com.solanches.solanches_sales_backend.repositories;

import br.com.solanches.solanches_sales_backend.entities.Neighbourhood;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface NeighbourhoodRepository extends Repository<Neighbourhood, Integer> {
    List<Neighbourhood> findAll();
}
