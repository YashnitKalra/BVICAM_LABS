/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Square;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author yashnit
 */
public class TestRunner {
    public static void main(String[] args) {
        Result r = JUnitCore.runClasses(SqaureCheckerTest.class);
        for(Failure fail: r.getFailures())
            System.out.println(fail.toString());
        if(r.wasSuccessful())
            System.out.println("Successfully Tested!!!");
    }
}