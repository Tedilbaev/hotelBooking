package com.project.hotelbooking.controllers;

import com.project.hotelbooking.dto.requests.HotelRequest;
import com.project.hotelbooking.dto.response.HotelResponse;
import com.project.hotelbooking.services.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public HotelResponse createHotel(@Valid @RequestBody HotelRequest hotelRequest) {
        return hotelService.createHotel(hotelRequest);
    }
}
