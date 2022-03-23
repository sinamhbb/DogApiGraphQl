package com.example.DogApi.repository;

import com.example.DogApi.entity.Dog;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog,Long> {
//    @Query("SELECT d.id, d.breed FROM Dog d WHERE d.id=:id")
//    String findDogBreedById(Long id);
//
//    @Query("SELECT d.id, d.breed FROM Dog d")
//    List<String> findDogBreeds();
//
//    @Query("SELECT d.id, d.name FROM Dog d")
//    List<String> findAllName();
//
//    @Modifying
//    @Query("DELETE FROM DOG d WHERE d.breed=:breed")
//    Boolean deleteDogBreed(String breed);
////
//    @Modifying(clearAutomatically = true)
//    @Query("UPDATE DOG d SET d.name=:newName WHERE d.id=:id")
//    Dog updateDogName(String newName, Long id);

}
