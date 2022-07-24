package com.zipcodewilmington.arrayutility;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    List<T> objectList;

    public ArrayUtility(T[] inputArray) {
        objectList = new ArrayList<>(Arrays.asList(inputArray));
    }

    public Object[] removeValue(T valueToRemove){
        for(int i = 0; i < objectList.size(); i++){
            objectList.remove(valueToRemove);
        }

        return objectList.toArray();
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate){
        return Collections.frequency(objectList, valueToEvaluate);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge){
        List<T> arrToMerge = new ArrayList<>(Arrays.asList(arrayToMerge));
        objectList.addAll(arrToMerge);

        return objectList.stream().reduce(BinaryOperator.maxBy(((o1, o2)
                -> Collections.frequency(objectList, o1) - Collections.frequency(objectList, o2)))).orElse(null);


    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){
        List<T> arrToMerge = new ArrayList<>(Arrays.asList(arrayToMerge));
        objectList.addAll(arrToMerge);

        return Collections.frequency(objectList, valueToEvaluate);
    }
}
