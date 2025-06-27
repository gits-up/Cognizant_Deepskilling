package test.java;

import main.java.PerformanceTester;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

public class PerformanceTesterTest {

    @Test
    void testTaskCompletesWithinTimeLimit() {
        PerformanceTester tester = new PerformanceTester();

        assertTimeout(Duration.ofMillis(200), () -> {
            tester.performTask();
        });
    }
}
