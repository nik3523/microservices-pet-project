package com.pet.project.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {
    private final int errorCode = 404;

    public EntityNotFoundException(Long id) {
        super(String.format("Entity with id: %d doesn't exist", id));
    }
}
