package org.spring.gobalexceptionspring.service;

import org.spring.gobalexceptionspring.model.Tourist;

import java.util.List;

public interface ITourist {
    String registerTourist(Tourist tourist);
    Tourist fetchTourist(Integer id);
    List<Tourist> fetchAllTourist();
}
