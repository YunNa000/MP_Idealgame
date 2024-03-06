package com.example.ideal;

import java.util.Random;
import android.widget.Toast;

public class RandomValues extends MainActivity{
    int randomArray[];
    public RandomValues(int arraySize){
        Random random = new Random();
        int array_length=32;
        randomArray = new int[array_length];

        for(int i=0; i<arraySize; i++) {
            randomArray[i] = random.nextInt(arraySize);
            for (int j = 0; j < i; j++) {
                if (randomArray[i] == randomArray[j]) {
                    i--;
                }
            }
        }
    }

    public int[] getRandomArray() {
        return randomArray;
    }

    public void setRandomArray(int[] randomArray) {
        this.randomArray = randomArray;
    }
}
