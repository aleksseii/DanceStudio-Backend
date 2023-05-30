package ru.aleksseii.dao;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public interface CrudDao<T> {

    T get(@Positive int id);

    @NotNull List<@NotNull T> getAll();

    void save(@NotNull T element);

    void delete(@Positive int id);
}
