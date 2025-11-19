package org.spring.gobalexceptionspring.repository;

import org.spring.gobalexceptionspring.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TouristRepository extends JpaRepository<Tourist , Integer> {
    boolean existsByPlaceName(String placeName);
}
