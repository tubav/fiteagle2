package org.fiteagle.dm.xmpp.frcp;

import java.io.IOException;

import org.fiteagle.dm.xmpp.frcp.ExecAdapter;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ExecAdapterTest {

	@Ignore
	@Test
	public void test() throws IOException, InterruptedException {
		ExecAdapter adapter = new ExecAdapter();
		String result = adapter.exec("echo 'foo'");
		Assert.assertNotNull(result);
		Assert.assertNotEquals(0, result.length());
		Assert.assertTrue(result.contains("foo"));
		System.out.println("S: '" + result + "'");
	}

}
