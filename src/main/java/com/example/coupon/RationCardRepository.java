package com.example.coupon;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface RationCardRepository extends CrudRepository<RationCardHolder, Long> {
    Optional<RationCardHolder> findByRationCardNumber(String rationCardNumber);
}
