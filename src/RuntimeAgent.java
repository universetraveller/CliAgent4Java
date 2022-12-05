package CliAgent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class RuntimeAgent {
	String command;
	boolean ERROR = true;
	public void setError(boolean ck){
		ERROR = ck;
	}
	public void setCommand(String cmd){
		command = cmd;
	}
	private String _run(String[] cmd){
		Process proc;
		StringBuilder ResultBuilder = new StringBuilder();
		String result = "";
		StringBuilder ErrorBuilder = new StringBuilder();
		String errs = "";
		try{
			proc = Runtime.getRuntime().exec(cmd);
			BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String getLine = null;
			while ((getLine = input.readLine()) != null){
				ResultBuilder.append(getLine).append("\n");
			}
			input.close();
			if (ERROR) {
				BufferedReader inputerr = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
				String errLine = null;
				while((errLine = inputerr.readLine()) != null){
					ErrorBuilder.append(errLine).append("\n");
				}
				inputerr.close();
			}
			proc.waitFor();
		}catch (IOException | InterruptedException e){
			e.printStackTrace();
		}
		result = ResultBuilder.toString();
		if (ERROR && result.length() == 0){
			errs = ErrorBuilder.toString();
			return errs;
		}
		if (ERROR) {
			return result + '\n' + ErrorBuilder.toString();
		}
		return result;
	}
	public String run(){
		return this._run(new String[0]);
	}
	/*public static String run(String[] cmd){
		return this._run(cmd);
	}*/
	public String run(String[] pars){
		String[] cmd = command.split(" ");
		String[] excmd = new String[cmd.length + pars.length];
		System.arraycopy(cmd, 0, excmd, 0, cmd.length);
		System.arraycopy(pars, 0, excmd, cmd.length, pars.length);
		return this._run(excmd);
	}
}

