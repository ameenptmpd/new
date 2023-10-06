package SeleniumProject.SeleniumProject;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSuiteRunner {

    public static void main(String[] args) {
        Class[] testClasses = {
        	BankingAppTest.class	
            
        };

        Result result = JUnitCore.runClasses(testClasses);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        if (result.wasSuccessful()) {
            System.out.println("All tests passed successfully.");
        }
    }
	
}
