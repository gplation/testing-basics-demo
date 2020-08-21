package com.demo.testing.mockito.case1;

public class CalcService {

    private AddService addService;

    public CalcService(AddService addService) {
        this.addService = addService;
    }

    public int calc(int a, int b) {
        return addService.add(a, b);
    }
}