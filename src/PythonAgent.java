package CliAgent;
import jep.SharedInterpreter;
import jep.Interpreter;
public class PythonAgent {
	public static void main(String[] args) {
		System.out.println("wait");
	}
	String execPath = "./";
	String module = "";
	String func = "";
	Interpreter interp = new SharedInterpreter();
	public PythonAgent(String execPath, String module, String func){
		this.execPath = execPath;
		this.module = module;
		this.func = func;
		this.init();
	}
	private void init(){
		if (this.module.length() == 0 || this.func.length() == 0){
			System.err.println("You should have a module and function name!");
		}
		this.interp.exec("import sys");
		this.interp.exec("sys.path.append('" + this.execPath + "')");
		this.interp.exec("import " + this.module);
		this.interp.exec("func_java_pythonAgentFunc = " + this.module + "." + this.func);
	}
	public void setExecPath(String p){
		this.execPath = p;
	}
	public void setModule(String m){
		this.module = m;
	}
	public void setFunc(String f){
		this.func = f;
	}
	private Object _runFunc(Object[] pars){
		return this.interp.invoke("func_java_pythonAgentFunc", pars);
	}
	private Object _noParameter(){
		return this.interp.getValue("func_java_pythonAgentFunc");
	}
	public Object execute(Object[] pars){
		return this._runFunc(pars);
	}
	public Object execute(){
		return this._noParameter();
	}
	public String getString(Object[] pars){
		return this._runFunc(pars).toString();
	}
	public String getString(){
		return this._noParameter().toString();
	}
}
