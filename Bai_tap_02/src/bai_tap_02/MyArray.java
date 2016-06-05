/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_tap_02;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/**
 *
 * @author Minh Nhi
 */
public class MyArray<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    private static final long serialVersionUID = 8683452581122892189L;
    private transient Object[] elementData;
    private int size;

    public MyArray(int initialCapacity) {
        super();
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illrgal Capacity: " + initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
    }

    public MyArray() {
        this(10);
    }

    public MyArray(Collection<? extends E> c) {
        elementData = c.toArray();
        size = elementData.length;
        if (elementData.getClass() != Object[].class) {
            elementData = Arrays.copyOf(elementData, size, Object[].class);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    E elementData(int index) {
        return (E) elementData[index];
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    @Override
    public int size() {
        return size;
    }
    
    public boolean add(E e) {
        ensureCapacity(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
     }
    
    public void add(int index, E element) {
         rangeCheckForAdd(index);
 
         ensureCapacity(size+1);  // Increments modCount!!
         System.arraycopy(elementData, index, elementData, index + 1,
                          size - index);
         elementData[index] = element;
         size++;
    }
    
    public void ensureCapacity(int minCapacity) {
         modCount++;
         int oldCapacity = elementData.length;
         if (minCapacity > oldCapacity) {
             Object oldData[] = elementData;
             int newCapacity = (oldCapacity * 3)/2 + 1;
             if (newCapacity < minCapacity)
                 newCapacity = minCapacity;
             // minCapacity is usually close to size, so this is a win:
             elementData = Arrays.copyOf(elementData, newCapacity);
         }
    }
    
    private void rangeCheck(int index) {
         if (index >= size)
             throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
             throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private String outOfBoundsMsg(int index) {
         return "Index: "+index+", Size: "+ size;
    }
}
