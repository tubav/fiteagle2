/*
 * An XML document type.
 * Localname: itype
 * Namespace: http://schema.mytestbed.net/omf/6.0/protocol
 * Java type: net.mytestbed.schema.omf.x60.protocol.ItypeDocument
 *
 * Automatically generated - do not modify.
 */
package net.mytestbed.schema.omf.x60.protocol.impl;
/**
 * A document containing one itype(@http://schema.mytestbed.net/omf/6.0/protocol) element.
 *
 * This is a complex type.
 */
public class ItypeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.mytestbed.schema.omf.x60.protocol.ItypeDocument
{
    private static final long serialVersionUID = 1L;
    
    public ItypeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ITYPE$0 = 
        new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "itype");
    
    
    /**
     * Gets the "itype" element
     */
    public net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum getItype()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ITYPE$0, 0);
            if (target == null)
            {
                return null;
            }
            return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "itype" element
     */
    public net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype xgetItype()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype target = null;
            target = (net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype)get_store().find_element_user(ITYPE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "itype" element
     */
    public void setItype(net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum itype)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ITYPE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ITYPE$0);
            }
            target.setEnumValue(itype);
        }
    }
    
    /**
     * Sets (as xml) the "itype" element
     */
    public void xsetItype(net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype itype)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype target = null;
            target = (net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype)get_store().find_element_user(ITYPE$0, 0);
            if (target == null)
            {
                target = (net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype)get_store().add_element_user(ITYPE$0);
            }
            target.set(itype);
        }
    }
    /**
     * An XML itype(@http://schema.mytestbed.net/omf/6.0/protocol).
     *
     * This is an atomic type that is a restriction of net.mytestbed.schema.omf.x60.protocol.ItypeDocument$Itype.
     */
    public static class ItypeImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype
    {
        private static final long serialVersionUID = 1L;
        
        public ItypeImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected ItypeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
