package com.demo.testing.mockito.case2;

public interface Response {

    public boolean isSuccessful();

    // returns string or null if failed
    public String getData();
}