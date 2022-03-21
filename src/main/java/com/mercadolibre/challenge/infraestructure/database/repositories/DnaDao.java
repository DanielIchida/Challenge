package com.mercadolibre.challenge.infraestructure.database.repositories;

import com.mercadolibre.challenge.infraestructure.database.entities.DnaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DnaDao extends JpaRepository<DnaEntity,Long> {

}
