package CliAgent.test;
import CliAgent.PythonAgent;
public class testPythonAgent{
	public static void test1(){
		PythonAgent PA = new PythonAgent("test", "getValue");
		PA.exec("print('Hello World!')");
		PA.close();
	}
	public static void test2(){
		PythonAgent PA = new PythonAgent("test", "returnValue");
		Object res = PA.execute();
		assert (long)res == 1;
		PA.close();
	}
	public static void test3(){
		PythonAgent PA = new PythonAgent("test", "getValue");
		Object res = PA.execute(new Object[]{1,2,3});
		assert (long)res == 2;
		PA.close();
	}
	public static void test4(){
		PythonAgent PA = new PythonAgent("test", "returnValue");
		String res = PA.getString();
		assert res.equals("1");
		PA.close();
	}
	public static void test5(){
		PythonAgent PA = new PythonAgent("test", "getValue");
		String res = PA.getString(new Object[]{1,2,3});
		assert res.equals("2");
		PA.close();
	}
}
