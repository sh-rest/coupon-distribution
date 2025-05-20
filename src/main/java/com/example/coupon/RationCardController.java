package com.example.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RationCardController {

    @Autowired
    private RationCardRepository repo;

    @GetMapping("/status/{card}")
    public ResponseEntity<?> checkStatus(@PathVariable String card) {
        return repo.findByRationCardNumber(card)
            .map(holder -> {
                LocalDate now = LocalDate.now();
                boolean eligible = holder.getLastCouponDate() == null ||
                    !holder.getLastCouponDate().getMonth().equals(now.getMonth()) ||
                    holder.getLastCouponDate().getYear() < now.getYear();
                return ResponseEntity.ok(Map.of(
                    "name", holder.getName(),
                    "eligible", eligible
                ));
            })
            .orElse(ResponseEntity.status(404).body("Ration Card not found"));
    }

    @PostMapping("/update/{card}")
    public ResponseEntity<?> updateCoupon(@PathVariable String card) {
        return repo.findByRationCardNumber(card)
            .map(holder -> {
                holder.setLastCouponDate(LocalDate.now());
                repo.save(holder);
                return ResponseEntity.ok("Coupon marked as given");
            })
            .orElse(ResponseEntity.status(404).body("Ration Card not found"));
    }
}
