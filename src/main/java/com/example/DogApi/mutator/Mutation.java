package com.example.DogApi.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.DogApi.entity.Dog;
import com.example.DogApi.exception.BreedNotFoundException;
import com.example.DogApi.exception.DogNotFoundException;
import com.example.DogApi.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Boolean deleteDogBreed(String breed) {
        AtomicReference<Boolean> deleted = new AtomicReference<>(false);
        Iterable<Dog> dogs = dogRepository.findAll();
        dogs.forEach(it -> {
            System.out.println("Breed: " + it.getBreed());
            if (Objects.equals(it.getBreed(), breed)){
                dogRepository.delete(it);
                deleted.set(true);
            }
        });

        if (!deleted.get()){
            throw new BreedNotFoundException("Breed Not Found", breed);
        }
        return deleted.get();
    }

    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
