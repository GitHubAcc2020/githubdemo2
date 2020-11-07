package app;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testcases.test1;
import testcases.test2;

@RunWith(Suite.class)
@SuiteClasses({test1.class,test2.class})
public class TestSuites 
{

}
