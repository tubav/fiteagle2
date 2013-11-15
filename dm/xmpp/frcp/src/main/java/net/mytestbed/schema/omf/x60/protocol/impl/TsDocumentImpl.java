/*
 * An XML document type.
 * Localname: ts
 * Namespace: http://schema.mytestbed.net/omf/6.0/protocol
 * Java type: net.mytestbed.schema.omf.x60.protocol.TsDocument
 *
 * Automatically generated - do not modify.
 */
package net.mytestbed.schema.omf.x60.protocol.impl;
/**
 * A document containing one ts(@http://schema.mytestbed.net/omf/6.0/protocol) element.
 *
 * This is a complex type.
 */
public class TsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.mytestbed.schema.omf.x60.protocol.TsDocument
{
    private static final long serialVersionUID = 1L;
    
    public TsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TS$0 = 
        new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "ts");
    
    
    /**
     * Gets the "ts" element
     */
    public java.lang.String getTs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ts" element
     */
    public org.apache.xmlbeans.XmlString xgetTs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TS$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ts" element
     */
    public void setTs(java.lang.String ts)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TS$0);
            }
            target.setStringValue(ts);
        }
    }
    
    /**
     * Sets (as xml) the "ts" element
     */
    public void xsetTs(org.apache.xmlbeans.XmlString ts)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TS$0);
            }
            target.set(ts);
        }
    }
}
