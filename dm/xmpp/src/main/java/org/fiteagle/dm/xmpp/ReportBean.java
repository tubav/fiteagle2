package org.fiteagle.dm.xmpp;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.jms.JMSException;
import javax.naming.NamingException;

import org.jivesoftware.smack.XMPPException;

@Stateless
public class ReportBean {
  
    @Resource(lookup="java:jboss/ee/concurrency/factory/default")
    private ManagedThreadFactory threadFactory;
 
    public void runReports() throws NamingException, JMSException, XMPPException {
        XMPP xmpp = new XMPP();
        Thread thread = threadFactory.newThread(xmpp);
        thread.start();
    }
}