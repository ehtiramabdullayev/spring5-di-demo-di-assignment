package guru.springframework.services;

import guru.springframework.patterns.Factory;
import guru.springframework.patterns.FactoryA;
import guru.springframework.patterns.FactoryB;

import java.util.HashMap;
import java.util.SortedMap;

/**
 * @author Ehtiram_Abdullayev on 9/3/2018
 * @project di-demo
 */
public class Test {
    private Factory factoryA;
    private Factory factoryB;

    public Test(Factory factoryA, Factory factoryB) {
        this.factoryA = factoryA;
        this.factoryB = factoryB;
    }


    public static void main(String[] args) {
        Test testFactory = new Test(new FactoryA(), new FactoryB());
        testFactory.factoryA.createProduct();
    }
}
