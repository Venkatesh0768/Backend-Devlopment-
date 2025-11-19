package org.pm.springdatajpa.repository;

import org.pm.springdatajpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User , Integer> {
    List<User> searchByName(String name);

    @Transactional
    @Modifying
    @Query("update User u set u.cost= :newCost where u.name= :userName")
    public int updateTHeCostByTheName(int newCost  , String userName);
}
