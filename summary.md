## ArrayTest
- should_resize_array()
1. The knowledge point of this unit test is to have the concept of Stack and implements it using an array. Offical document: https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
2. The original MyStack class is not yet implemented thus test case will fail.
3. The counter is used as an index of the Stack where the topest position is. For method push(), since we push value after ensure the capacity, so we can directly use 'storage[count++] = value' to assign the value and do increment on the counter. For method ensureCapacity(), we simply create a new array of size newCapacity and then copy the values from the original storage, then assign this array to variable storage, and also update the value of capacity. For method pop(), since the value of 'counter' is point the position that can insert a value, so the actual topest element that should be pop is in the position of 'counter - 1', so after checking counter is larger than 0, we can return storage[--counter], thus can pop the element and decrease the counter.
4. No

## CollectionsTest
- should_go_through_an_iterator()
1. The knowledge point of this unit test is to know that concept of Iterator and Iteratable. Offical document: https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html
2. The original expected result is an empty list at first, so the test case will fail.
3. Implement the createList(), by checking iterator.hasNext() as the condition of a while loop, keep adding the value of iterator.next() to the return list will be able to extract the value from the iterable to the list.
4. No

- should_create_a_sequence_without_putting_all_items_into_memory()
1. The knowledge point of this unit test is to understand that concept of Iterator and Iteratable. Offical document: https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html
2. The original class SequenceIterator is not yet implemented and will throw NotImplementedException.
3. For member of SequenceIterator, we need two variables start and end to store the values which are passed to the consturctor. Since we only need to output the value from start to end and not include end, for hasNext(), we only need to return if start is smaller than end, if equals it should return false as we don't need the value of 'end'. For next(), we only need to return the current value of start and then increment its value, so only need to return start++.
4. No

- should_predict_linked_list_operation_result()
1. The knowledge point of this unit test is to know the class LinkedList and its iterator. Offical document: https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html
2. The original expected result are "I", "Don't", "Know" at first, which is definitely not the correct result.
3. At first the linked list has the value of "Amy", "Bob", "Carl". Calling next() will let the cursor point to the position after "Carl", and the calling of add() insert the value "Juliet", since the value is adding before the current cursor, the call of previous() should return "Juliet", and thus calling remove() will remove "Juliet". Therefore the correct expected result is "Amy", "Bob", "Carl". 
4. No

- should_generate_distinct_sequence_on_the_fly()
1. The knowledge point of this unit test is to understand that concept of Iterator and Iteratable. Offical document: https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html
2. The original class DistinctIterator is not yet implemented and will throw NotImplementedException.
3. Since calling the next() must return a value, it is hard to prevent not to return duplicate value if we don't know all the distinct value in advance. Therefore, I create a HashMap<E, Boolean> called storeMap, and a int outputCount which counts the total number of values the DistinctIterator return. When the constructor receive the large iterator, I call the method of constructStoreMap(), which will tranverse the the whole iterable and put the value return by next(), which would be unique in the storeMap as I store it as a key, the value is set as false to indicate that it havn't been return by the next() of DistinctIterator. For the hasNext(), we only need to check if outputCount is equals to the size of the storeMap, if not, that means there is still distinct value(s) that can be returned. For next(), we only need to return the value that is marked as false in the storeMap, and mark it as true.
4. No

- should_reflects_back_to_original_list_for_sub_range()
1. The knowledge point of this unit test is to know the affect of calling remove() on a sublist. Offical document: https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html
2. The original expected results are all 0 value sat first.
3. Since we get the subset from index 3 to 10, which values should be 3 to 9, cleaning this subset will affect the original list as it is worked as a view of the original list, so the original list should only have the value 0, 1, 2, 10, 11 remaining, which is the expected result.
4. No
