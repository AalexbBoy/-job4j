package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamApi {
    public List<Integer> genList() {
        final Stream<Integer> eranAnswer = Stream.iterate(1, i -> i > 0 ? -i : (-i + 1));
        return eranAnswer.limit(10).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Integer> resList(List<Integer> myList) {
        myList = myList.stream().filter(i -> i > 0).collect(Collectors.toList());
        return myList;
    }
}
