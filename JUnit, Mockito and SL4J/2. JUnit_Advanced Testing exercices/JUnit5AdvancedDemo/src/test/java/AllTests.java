package test.java;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    EvenCheckerTest.class,
    DummyTest.class
})
public class AllTests {
	
}
