package br.com.poc.arsenal.exception;

public class ArsenalException extends RuntimeException{
    public ArsenalException(Long id) {
        super("Could not find employee " + id);
    }
}
