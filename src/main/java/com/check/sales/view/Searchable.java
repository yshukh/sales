package com.check.sales.view;

import java.util.Collection;

public interface Searchable<E, V> {
    Collection<E> search(V value);
}