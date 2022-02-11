package main;

import container.DependencyInjectionContainer;
import io.SystemIO;

public class Main {
    public static void main(String[] args) {
        var systemIO = new SystemIO(new DependencyInjectionContainer());
        systemIO.process();
    }
}
