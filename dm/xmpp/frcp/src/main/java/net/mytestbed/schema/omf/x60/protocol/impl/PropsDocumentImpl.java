/*
 * An XML document type.
 * Localname: props
 * Namespace: http://schema.mytestbed.net/omf/6.0/protocol
 * Java type: net.mytestbed.schema.omf.x60.protocol.PropsDocument
 *
 * Automatically generated - do not modify.
 */
package net.mytestbed.schema.omf.x60.protocol.impl;
/**
 * A document containing one props(@http://schema.mytestbed.net/omf/6.0/protocol) element.
 *
 * This is a complex type.
 */
public class PropsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.mytestbed.schema.omf.x60.protocol.PropsDocument
{
    private static final long serialVersionUID = 1L;
    
    public PropsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROPS$0 = 
        new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "props");
    
    
    /**
     * Gets the "props" element
     */
    public net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props getProps()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props target = null;
            target = (net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props)get_store().find_element_user(PROPS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "props" element
     */
    public void setProps(net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props props)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props target = null;
            target = (net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props)get_store().find_element_user(PROPS$0, 0);
            if (target == null)
            {
                target = (net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props)get_store().add_element_user(PROPS$0);
            }
            target.set(props);
        }
    }
    
    /**
     * Appends and returns a new empty "props" element
     */
    public net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props addNewProps()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props target = null;
            target = (net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props)get_store().add_element_user(PROPS$0);
            return target;
        }
    }
    /**
     * An XML props(@http://schema.mytestbed.net/omf/6.0/protocol).
     *
     * This is a complex type.
     */
    public static class PropsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props
    {
        private static final long serialVersionUID = 1L;
        
        public PropsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        
    }
}
