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
    public void run(String... strings) throws Exception {

        Hotel lalitha = new Hotel(
                "Lalitha",
                150,
                new Address("Matara", "Sri Lanka"),
                Arrays.asList(
                        new Review("Jeewantha", 9, false),
                        new Review("Neminda", 1, true)
                )
        );
        Hotel marriot = new Hotel(
                "Marriot",
                130,
                new Address("Paris", "France"),
                Arrays.asList(
                        new Review("Ovindu", 8, false),
                        new Review("Archana", 7, true)
                )
        );



        //drop all hotels
        this.hotelRepository.deleteAll();

        //add our hotels to database
        List<Hotel> hotels = Arrays.asList(marriot,lalitha);
        this.hotelRepository.saveAll(hotels);
    }
}
