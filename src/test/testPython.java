import CliAgent.PythonAgent;
public class testPython{
	public static void main(String[] args){
		PythonAgent pa = new PythonAgent("./", "testPython", "interface");
		Object[] ags = new Object[]{"public static void main(String[] args){}", 15, "./testPython.py", "./CliAgent"};
		String k = pa.getString(ags);
		System.out.println(k);
	}
}

