package com.mongodb_rest_api.springbootmongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private HotelRepository hotelRepository;

    public DbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Hotel marriot = new Hotel(
                "Marriot",
                130,
                new Address("Paris", "France"),
                Arrays.asList(
                        new Review("Ovindu", 8, false),
                        new Review("Archana", 7, true)
                )
        );
        Hotel lalitha = new Hotel(
                "Lalitha",
                150,
                new Address("Matara", "Sri Lanka"),
                Arrays.asList(
                        new Review("Jeewantha", 9, false),
                        new Review("Neminda", 1, true)
                )
        );
        Hotel hilton = new Hotel(
                "Hilton",
                200,
                new Address("Mumbai", "India"),
                Arrays.asList(
                        new Review("Chanaka", 4, true),
                        new Review("Hansa", 5, false)
                )
        );

        //drop all hotels
        this.hotelRepository.deleteAll();

        //add our hotels to database
        List<Hotel> hotels = Arrays.asList(marriot,lalitha, hilton);
        this.hotelRepository.saveAll(hotels);
    }
}
