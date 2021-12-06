package by.bsuir.wt.vlad.tasks.fourth.builder;

import by.bsuir.wt.vlad.tasks.fourth.exception.RepositoryException;

import java.sql.ResultSet;

public interface Builder<T> {
    T build(ResultSet resultSet) throws RepositoryException;
}
