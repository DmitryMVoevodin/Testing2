package com.company.junit.stub.services;

import com.company.junit.stub.repositories.UserRepository;
import com.company.junit.stub.repositories.entities.User;

import java.util.Optional;

public class UserRepositoryStub implements UserRepository {

    public final static long ID = 1;
    public final static String FIRST_NAME = "Bob";
    public final static String LAST_NAME = "Miller";
    public final static long ID_FOR_EXCEPTION = 0;

    @Override
    public Optional<User> findById(Long aLong) {
        Optional<User> userOptional;
        userOptional = (aLong == ID) ? Optional.of(new User(ID, FIRST_NAME, LAST_NAME)) : Optional.empty();
        return userOptional;
    }

    @Override
    public <S extends User> S save(S s) {
        return null;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
