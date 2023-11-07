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
    Workout newWorkout = newWorkoutDto.dtoToEntity(newWorkoutDto);
    Workout savedWorkout = fakeFitnessDatabase.saveWorkout(newWorkout);
    return WorkoutDto.entityToDto(savedWorkout);
  }

  @Override
  public Optional<WorkoutDto> getWorkout(Long id) {
    Optional<Workout> workoutOptional = fakeFitnessDatabase.getWorkout(id);

    if (workoutOptional.isEmpty()) {
      return Optional.empty();
    }

    Workout workout = workoutOptional.get();
    WorkoutDto workoutDto = WorkoutDto.entityToDto(workout);

    return Optional.of(workoutDto);
  }

  @Override
  public List<WorkoutDto> getAllWorkouts() {
    List<Workout> workouts = fakeFitnessDatabase.getAllWorkouts();
    return workouts.stream().map(WorkoutDto::entityToDto).toList();
  }
}
