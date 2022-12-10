package CliAgent.test;
import CliAgent.test.testPythonAgent;
import CliAgent.test.testRuntimeAgent;
public class runtests{
	public static void main(String[] args){
		testPythonAgent.test1();
		testPythonAgent.test2();
		testPythonAgent.test3();
		testPythonAgent.test4();
		testPythonAgent.test5();
		testRuntimeAgent.testcase_1();
		testRuntimeAgent.testcase_2();
		testRuntimeAgent.testcase_3();
		testRuntimeAgent.testcase_4();
		System.out.println("pass");
	}
}
