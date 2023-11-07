package com.betrybe.fitness.controller;

import com.betrybe.fitness.dto.WorkoutCreationDto;
import com.betrybe.fitness.dto.WorkoutDto;
import com.betrybe.fitness.service.FitnessService;
import com.betrybe.fitness.service.FitnessServiceInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementa camada de controller.
 */
@RestController
@RequestMapping("/fitness")
public class FitnessController implements FitnessControllerInterface {

  private final FitnessServiceInterface fitnessService;

  @Autowired
  public FitnessController(FitnessServiceInterface fitnessService) {
    this.fitnessService = fitnessService;
  }

  @GetMapping
  public ResponseEntity<String> welcomeMessage() {
    return ResponseEntity.status(200).body("Boas vindas à API de Fitness!");
  }

  /**
   * Implementa rota GET para busca de workout por id.
   */
  @GetMapping("/workouts/{id}")
  public ResponseEntity<WorkoutDto> getWorkout(@PathVariable Long id) {
    Optional<WorkoutDto> workoutDto = fitnessService.getWorkout(id);

    if (workoutDto.isEmpty()) {
      return ResponseEntity.status(404).build();
    }
    return ResponseEntity.status(200).body(workoutDto.get());
  }

  @PostMapping("/workouts")
  public ResponseEntity<WorkoutDto> saveWorkout(
      @RequestBody WorkoutCreationDto workoutCreationDto) {
    WorkoutDto workoutDto = fitnessService.saveWorkout(workoutCreationDto);
    return ResponseEntity.status(201).body(workoutDto);
  }

  @GetMapping("/workouts")
  public ResponseEntity<List<WorkoutDto>> getAllWorkouts() {
    List<WorkoutDto> workoutDtos = fitnessService.getAllWorkouts();
    return ResponseEntity.status(200).body(workoutDtos);
  }
}
