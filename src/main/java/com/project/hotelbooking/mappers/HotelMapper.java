package com.project.hotelbooking.mappers;

import com.project.hotelbooking.dto.response.HotelResponse;
import com.project.hotelbooking.models.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    HotelResponse toResponse(Hotel hotel);
}
