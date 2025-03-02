package com.CarEcommerse.CarEcommerse.service;


import com.CarEcommerse.CarEcommerse.exception.ResourceNotFoundException;
import com.CarEcommerse.CarEcommerse.model.Car;
import com.CarEcommerse.CarEcommerse.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> getAvailableCars() {
        return carRepository.findByAvailableTrue();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id: " + id));
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car carDetails) {
        Car car = getCarById(id);
        car.setBrand(carDetails.getBrand());
        car.setModel(carDetails.getModel());
        car.setYear(carDetails.getYear());
        car.setColor(carDetails.getColor());
        car.setPrice(carDetails.getPrice());
        car.setDescription(carDetails.getDescription());
        car.setImageUrl(carDetails.getImageUrl());
        car.setAvailable(carDetails.getAvailable());
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        Car car = getCarById(id);
        carRepository.delete(car);
    }
}