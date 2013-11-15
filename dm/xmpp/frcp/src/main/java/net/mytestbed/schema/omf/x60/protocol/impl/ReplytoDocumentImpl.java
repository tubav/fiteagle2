/*
 * An XML document type.
 * Localname: replyto
 * Namespace: http://schema.mytestbed.net/omf/6.0/protocol
 * Java type: net.mytestbed.schema.omf.x60.protocol.ReplytoDocument
 *
 * Automatically generated - do not modify.
 */
package net.mytestbed.schema.omf.x60.protocol.impl;
/**
 * A document containing one replyto(@http://schema.mytestbed.net/omf/6.0/protocol) element.
 *
 * This is a complex type.
 */
public class ReplytoDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.mytestbed.schema.omf.x60.protocol.ReplytoDocument
{
    private static final long serialVersionUID = 1L;
    
    public ReplytoDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REPLYTO$0 = 
        new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "replyto");
    
    
    /**
     * Gets the "replyto" element
     */
    public java.lang.String getReplyto()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REPLYTO$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "replyto" element
     */
    public org.apache.xmlbeans.XmlString xgetReplyto()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REPLYTO$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "replyto" element
     */
    public void setReplyto(java.lang.String replyto)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REPLYTO$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REPLYTO$0);
            }
            target.setStringValue(replyto);
        }
    }
    
    /**
     * Sets (as xml) the "replyto" element
     */
    public void xsetReplyto(org.apache.xmlbeans.XmlString replyto)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REPLYTO$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(REPLYTO$0);
            }
            target.set(replyto);
        }
    }
}
