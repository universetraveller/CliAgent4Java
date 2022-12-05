import CliAgent.RuntimeAgent;
public class test{
	public static void main(String[] args){
		RuntimeAgent rt = new RuntimeAgent();
		String res = rt.run(new String{"python3", "test.py", "a", "rs"});
		System.out.println(res);
	}
}
