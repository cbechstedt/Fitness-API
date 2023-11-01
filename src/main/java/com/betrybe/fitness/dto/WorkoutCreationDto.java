package com.betrybe.fitness.dto;

import com.betrybe.fitness.model.Workout;

public record WorkoutCreationDto(String name, Integer repetitions, String secretTechnique) {

  public static WorkoutCreationDto entityToDto(Workout workout) {
    return new WorkoutCreationDto(workout.getName(), workout.getRepetitions(),
        workout.getSecretTechnique());
  }

  public Workout dtoToEntity(WorkoutCreationDto workoutCreationDto) {
    Workout workout = new Workout();
    workout.setName(name);
    workout.setRepetitions(repetitions);
    workout.setSecretTechnique(secretTechnique);
    return workout;
  }
}
