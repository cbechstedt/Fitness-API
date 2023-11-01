package com.betrybe.fitness.dto;

import com.betrybe.fitness.model.Workout;

/**
 * Implementa DTO para a entidade Workout.
 */
public record WorkoutDto(Long id, String name, Integer repetitions) {

  /**
   * Método para transformar Workout em WorkoutDto.
   */
  public static WorkoutDto entityToDto(Workout workout) {
    return new WorkoutDto(workout.getId(), workout.getName(), workout.getRepetitions());
  }

  /**
   * Método para transformar WorkoutDto em Workout.
   */
  public Workout dtoToEntity(WorkoutDto workoutDto) {
    Workout workout = new Workout();
    workout.setId(id);
    workout.setName(name);
    workout.setRepetitions(repetitions);
    return workout;
  }
}
