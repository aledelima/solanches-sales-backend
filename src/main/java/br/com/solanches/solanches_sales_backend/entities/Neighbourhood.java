package br.com.solanches.solanches_sales_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tbbairro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Neighbourhood {

    @Id
    @Column(name = "codBairro")
    private Integer id;

    @Column(name = "nome")
    private String name;

    @Column(name = "precoEntrega")
    private BigDecimal deliveryPrice;

}
