package com.project.hotelbooking.repositories;

import com.project.hotelbooking.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    boolean existsByAddress(String address);
}
