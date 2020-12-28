package com.mongodb_rest_api.springbootmongodb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/all")
    public List<Hotel> getAll() {
        List<Hotel> hotels = this.hotelRepository.findAll();
        return hotels;
    }

    @GetMapping("/{id}")
    public Hotel getById(@PathVariable("id") String id){
        Hotel hotel=this.hotelRepository.findHotelById(id);
        return hotel;
    }

   /*
    @GetMapping("{review}")
    public List<Hotel> getByReview(@PathVariable("maxPrice") int review){
        List<Hotel> hotels=this.hotelRepository.findByReviews(review);
        return hotels;
    }
    */

}
