package com.project.hotelbooking.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record HotelRequest(
    @NotBlank(message = "{hotel.name.notBlank}")
    @Size(min = 2, max = 100, message = "{hotel.name.size}")
    String name,
    @NotBlank(message = "{hotel.address.notBlank}")
    @Size(min = 5, max = 200, message = "{hotel.address.size}")
    String address
) {}
