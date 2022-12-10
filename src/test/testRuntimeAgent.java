package CliAgent.test;
import CliAgent.RuntimeAgent;
public class testRuntimeAgent{
	public static void testcase_1(){
		// deprecated
		return;
		//RuntimeAgent RA = new RuntimeAgent();
		//String str = RA.run();
		//assert str.trim().isEmpty();
	}
	public static void testcase_2(){
		RuntimeAgent RA = new RuntimeAgent();
		String str = RA.run(new String[]{"echo", "not_null"});
		assert str.equals("not_null");
	}
	public static void testcase_3(){
		RuntimeAgent RA = new RuntimeAgent("python3 test.py");
		String str = RA.run(new String[]{"testemail", "mail.com"});
		assert str.equals("testemail@mail.com");
	}
	public static void testcase_4(){
		RuntimeAgent RA = new RuntimeAgent("echo not_null");
		String str = RA.run();
		assert str.equals("not_null");
	}
}
