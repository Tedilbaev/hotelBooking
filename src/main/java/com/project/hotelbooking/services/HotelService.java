package com.project.hotelbooking.services;

import com.project.hotelbooking.dto.requests.HotelRequest;
import com.project.hotelbooking.dto.response.HotelResponse;
import com.project.hotelbooking.mappers.HotelMapper;
import com.project.hotelbooking.models.Hotel;
import com.project.hotelbooking.repositories.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    @Transactional
    public HotelResponse createHotel(HotelRequest hotelRequest) {
        if (hotelRepository.existsByAddress(hotelRequest.address())) {
            throw new RuntimeException("{hotel.address.error.existsByAddress}");
        }
        Hotel hotel = Hotel.builder()
            .name(hotelRequest.name())
            .address(hotelRequest.address())
            .build();
        return hotelMapper.toResponse(hotelRepository.save(hotel));
    }
}
