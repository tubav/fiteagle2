package org.fiteagle.dm.xmpp.frcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecAdapter {

	public String exec(String string) throws IOException, InterruptedException {
		Runtime r = Runtime.getRuntime();
		//Process p = r.exec(string);
		Process p = r.exec("");
		p.waitFor();
		BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = "";
		String result = "";
		while ((line = b.readLine()) != null) {
		  result += line;
		}
		
		return result;
	}

}
