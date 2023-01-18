package com.visualnuts.exercise.one;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExerciseOne {

    public boolean isDividedBy(int number, int factor){
        return number % factor == 0;
    }

    public void checkWordBasedOnNumber(List<Integer> numbers){
        numbers.forEach(number -> {
            if (isDividedBy(number, 15)){
                System.out.println("Visual Nuts");
            }
            else if(isDividedBy(number, 3)){
                System.out.println("Visual");
            }
            else if(isDividedBy(number, 5)){
                System.out.println("Nuts");
            }
            else{
                System.out.println(number);
            }
        });
    }

    public static void main(String[] args) {
        ExerciseOne exerciseOne = new ExerciseOne();
        exerciseOne.checkWordBasedOnNumber(IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList()));
    }
}
