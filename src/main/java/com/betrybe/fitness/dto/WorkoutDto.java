package com.betrybe.fitness.dto;

import com.betrybe.fitness.model.Workout;

public record WorkoutDto(Long id, String name, Integer repetitions) {

  public static WorkoutDto entityToDto(Workout workout) {
    return new WorkoutDto(workout.getId(), workout.getName(), workout.getRepetitions());
  }

  public Workout dtoToEntity(WorkoutDto workoutDto) {
    Workout workout = new Workout();
    workout.setId(id);
    workout.setName(name);
    workout.setRepetitions(repetitions);
    return workout;
  }
}
