package com.cesi.repository;

import javafx.collections.ObservableList;

/**
 * Created by Philippe on 03/06/2017.
 */
public interface Repo<T> {
    ObservableList<T> getListing();
    ObservableList<T> getAll(String tableName, String columnName);
}
