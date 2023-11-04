package com.betrybe.fitness.service;

import com.betrybe.fitness.database.FakeFitnessDatabase;
import com.betrybe.fitness.dto.WorkoutCreationDto;
import com.betrybe.fitness.dto.WorkoutDto;
import com.betrybe.fitness.model.Workout;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementa camada de serviço.
 */
@Service
public class FitnessService implements FitnessServiceInterface {

  private final FakeFitnessDatabase fakeFitnessDatabase;

  @Autowired
  public FitnessService(FakeFitnessDatabase fakeFitnessDatabase) {
    this.fakeFitnessDatabase = fakeFitnessDatabase;
  }

  @Override
  public WorkoutDto saveWorkout(WorkoutCreationDto newWorkoutDto) {
    return null;
  }

  @Override
  public Optional<WorkoutDto> getWorkout(Long id) {
    Optional<Workout> workoutOptional = fakeFitnessDatabase.getWorkout(id);

    if (workoutOptional.isPresent()) {
      Workout workout = workoutOptional.get();
      WorkoutDto workoutDto = WorkoutDto.entityToDto(workout);
      
      return Optional.of(workoutDto);
    }

    return Optional.empty();
  }

  @Override
  public List<WorkoutDto> getAllWorkouts() {
    return null;
  }
}
