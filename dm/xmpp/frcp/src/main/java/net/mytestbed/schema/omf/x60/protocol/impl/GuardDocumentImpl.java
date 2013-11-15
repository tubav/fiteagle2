/*
 * An XML document type.
 * Localname: guard
 * Namespace: http://schema.mytestbed.net/omf/6.0/protocol
 * Java type: net.mytestbed.schema.omf.x60.protocol.GuardDocument
 *
 * Automatically generated - do not modify.
 */
package net.mytestbed.schema.omf.x60.protocol.impl;
/**
 * A document containing one guard(@http://schema.mytestbed.net/omf/6.0/protocol) element.
 *
 * This is a complex type.
 */
public class GuardDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.mytestbed.schema.omf.x60.protocol.GuardDocument
{
    private static final long serialVersionUID = 1L;
    
    public GuardDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GUARD$0 = 
        new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "guard");
    
    
    /**
     * Gets the "guard" element
     */
    public net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard getGuard()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard target = null;
            target = (net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard)get_store().find_element_user(GUARD$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "guard" element
     */
    public void setGuard(net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard guard)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard target = null;
            target = (net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard)get_store().find_element_user(GUARD$0, 0);
            if (target == null)
            {
                target = (net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard)get_store().add_element_user(GUARD$0);
            }
            target.set(guard);
        }
    }
    
    /**
     * Appends and returns a new empty "guard" element
     */
    public net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard addNewGuard()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard target = null;
            target = (net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard)get_store().add_element_user(GUARD$0);
            return target;
        }
    }
    /**
     * An XML guard(@http://schema.mytestbed.net/omf/6.0/protocol).
     *
     * This is a complex type.
     */
    public static class GuardImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard
    {
        private static final long serialVersionUID = 1L;
        
        public GuardImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        
    }
}
