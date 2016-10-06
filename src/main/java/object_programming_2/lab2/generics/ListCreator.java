package object_programming_2.lab2.generics;

import java.util.List;

public class ListCreator {

    public static ListCreator collectFrom(List<Integer> list){
        return new ListCreator();
    }

    public ListCreator when(Selector sel){
        return new ListCreator();
    }

    public void mapEvery(Mapper map){

    }
}
