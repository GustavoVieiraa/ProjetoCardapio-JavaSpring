package dev.cardapio.controller;

import dev.cardapio.food.Food;
import dev.cardapio.food.FoodRepository;
import dev.cardapio.food.FoodRequestDTO;
import dev.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*") // for production appoint origins
    @GetMapping
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList = repository.findAll().stream()
                .map(FoodResponseDTO::new).toList();
        return foodList;
    }


}
