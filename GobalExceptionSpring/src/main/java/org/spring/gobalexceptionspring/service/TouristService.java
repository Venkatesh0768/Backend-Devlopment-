package org.spring.gobalexceptionspring.service;

import org.spring.gobalexceptionspring.configuration.UserAlreadyExistsException;
import org.spring.gobalexceptionspring.model.Tourist;
import org.spring.gobalexceptionspring.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService implements  ITourist{
    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    @Override
    public String registerTourist(Tourist tourist) {
        if (touristRepository.existsByPlaceName(tourist.getPlaceName())) {
            throw new UserAlreadyExistsException(
                    "Tourist already exists with place: " + tourist.getPlaceName()
            );
        }
        touristRepository.save(tourist);
        return "User Register Successfully";
    }


    @Override
    public Tourist fetchTourist(Integer id) {
        return null;
    }

    @Override
    public List<Tourist> fetchAllTourist() {
        return List.of();
    }
}
