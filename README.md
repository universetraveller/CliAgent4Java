# CliAgent4Java
This project is a command line interface agent aiming to simplify the procedure of calling other platforms' scripts or codes from Java Platform.  
Trying to provide a very simple way to call commands from java, it will reduce you lines of coding.  

---  
# Features  
CliAgent4Java temporarily contains 2 features:  
1. **RuntimeAgent**: Call almost all scripts which can run on bash/terminal; it is implemented based on Java Runtime.  
2. **PythonAgent**: Call python function without creating new processes, only with package jep.  

---  
# How to run CliAgent4Java  
## Installation  
* If you only want to use RuntimeAgent, just build the sourcecode of it or directly download the .jar package in ./packages folder.  
* If you want to use PythonAgent, you should install jep (https://github.com/ninia/jep) at first, and you can install it easily by `pip install jep`; notice you should have java enviroment and set the JAVA_HOME enviroment variable.  
## Usage  
### RuntimeAgent  
- #### Menber variables:  
1. **String command**: the command(s) you will call by RuntimeAgent.  
2. **boolean ERROR**: Whether to get error output of the command(s), it will get the standard error message; default is true.  
3. **RuntimeAgent(String command/String[] commands)**: Constructor.  
- #### Member functions:  
1. **setError(boolean)**: to set the member variable ERROR.  
2. **setCommand(String)**: to set the command(s) to be called.  
3. **String run(String[])**: to call command(s) with command line arguments.  
4. **String run()**: call command(s) without cmd arguments.  
Notice that the RuntimeAgent only returns type String for it is implemented by get standard output of the script.  So, you should print your result by the script to call.  
- #### Example  
```
import CliAgent.RuntimeAgent;
public class test{
	public static void main(String[] args){
		RuntimeAgent rt = new RuntimeAgent();
		String res = rt.run(new String[]{"python3", "test.py", "a", "b"});  //empty command
		System.out.println(res);
    rt.setCommand("python3 test.py");  //commands
    res = rt.run(new String[]{"a", "b"});
		System.out.println(res);
	}
}
```
### PythonAgent  
- #### Member variables:  
1. **String execPath**: The root working path of your python code, such as you want to call './test/folder/testfolder.py', the execPath should be './test/folder', without that the jep could not access your code.  
2. **String module**: the module contains needed functions, such as the example of execPath, the module should be 'testfolder'.  
3. **String func**: the function name you want to call, it would be renamed as 'func_java_pythonAgentFunc', so do not write a function with same name, unless you edit the source code of PythonAgent.  
4. **jep.Interpreter interp**: the inside interpreter of python (Embedded Cython in Java), it control all the executions of the python code.  
5. **PythonAgent((String execPath,) String module, String func)**: Constructor of PythonAgent, default execPath is './'.  
- #### Member functions:  
1. **setExecPath/setModule/setFunc**, parameter: String, set the member variable of the agent.  
2. **Object execute**, parameter: Object[] or None, execute the function and get the return value with/without parameters. The Object[] parameter could contain various types such as String, int.  
3. **String getString**, parameter: Object[] or None, execute the function, and convert the return value as String type.  
4. **void exec(String)**: execute string type script at Embedded Cython jep.  
5. **void close()**: close a jep interpreter, you must keep only an interpreter at single thread, so you should close it before creating a new one.  
- #### Example  
```
import CliAgent.PythonAgent;
public class testPython{
	public static void main(String[] args){
		PythonAgent pa = new PythonAgent("./", "testPython", "interface");  //Construct a based PythonAgent Object  
		Object[] ags = new Object[]{"String1", 15, "./testPython.py", "./CliAgent"};
		String res = pa.getString(ags);  //arguments are dilivered from java to cython
		System.out.println(res);
	}
}
```  
- #### Notice  
Notice that when use PythonAgent, follow the requirements of jep: https://github.com/ninia/jep/wiki/Getting-Started  
A jep folder is also in packages folder, you could have a try if you do not want to install it directly.  
Notice the setting of enviroment variables of jep, or use `java -cp :/**/jep-*.jar -Djava.library.path=/**/jep/ ClassTobeCalled` instead.  

---  
## Dependencies  
JDK (>=1.8 when use PythonAgent)    
Python >= 3.5 (when use PythonAgent)  
Jep (when use PythonAgent)  

---  
## Others
Welcome for comments, bug reports and contributions. If there is any problem please feel free to add an issue.  
