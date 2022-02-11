package mock;

import io.SystemIO;

public class mock {
    public static void main(String[] args) {
        var systemIO = new SystemIO(new MockDependencyInjectionContainer());
        systemIO.process();
    }
}
