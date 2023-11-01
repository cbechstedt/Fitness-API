package com.betrybe.fitness.dto;

import com.betrybe.fitness.model.Workout;

/**
 * Implementa DTO de criação para a entidade Workout.
 */
public record WorkoutCreationDto(String name, Integer repetitions, String secretTechnique) {

  /**
   * Método para transformar Workout em WorkoutCreationDto.
   */
  public static WorkoutCreationDto entityToDto(Workout workout) {
    return new WorkoutCreationDto(workout.getName(), workout.getRepetitions(),
        workout.getSecretTechnique());
  }

  /**
   * Método para transformar WorkoutCreationDto em Workout.
   */
  public Workout dtoToEntity(WorkoutCreationDto workoutCreationDto) {
    Workout workout = new Workout();
    workout.setName(name);
    workout.setRepetitions(repetitions);
    workout.setSecretTechnique(secretTechnique);
    return workout;
  }
}
