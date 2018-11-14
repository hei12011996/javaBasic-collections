package com.cultivation.javaBasic.showYourIntelligence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class DistinctIterable<T> implements Iterable<T> {
    private Iterable<T> iterable;

    public DistinctIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        return new DistinctIterator<>(iterable.iterator());
    }

    public List<T> toList() {
        ArrayList<T> result = new ArrayList<>();
        this.forEach(result::add);
        return result;
    }
}

class DistinctIterator<E> implements Iterator<E> {
    // TODO: Implement the class to pass the test. Note that you cannot put all items into memory or you will fail.
    // <--start
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final Iterator<E> iterator;
    private HashMap<E, Boolean> storeMap;
    private int outputCount;

    DistinctIterator(Iterator<E> iterator) {
        this.iterator = iterator;
        this.storeMap = new HashMap<E, Boolean>();
        this.outputCount = 0;
        constructStoreMap();
    }

    private void constructStoreMap(){
        while(iterator.hasNext()){
            storeMap.putIfAbsent(iterator.next(), false);
        }
    }

    @Override
    public boolean hasNext() {
        return outputCount < storeMap.size();
//        throw new NotImplementedException();
    }

    @Override
    public E next() {
        outputCount++;
        E returnObject = null;
        for (Map.Entry<E, Boolean> entry : storeMap.entrySet()){
            if(!entry.getValue()){
                returnObject = entry.getKey();
                entry.setValue(true);
                break;
            }
        }
        return returnObject;
//        throw new NotImplementedException();
    }
    // --end->
}