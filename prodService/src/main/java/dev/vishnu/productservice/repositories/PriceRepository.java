package dev.vishnu.productservice.repositories;

import dev.vishnu.productservice.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
}
