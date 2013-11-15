/*
 * An XML document type.
 * Localname: env
 * Namespace: http://schema.mytestbed.net/omf/6.0/protocol
 * Java type: net.mytestbed.schema.omf.x60.protocol.EnvDocument
 *
 * Automatically generated - do not modify.
 */
package net.mytestbed.schema.omf.x60.protocol.impl;
/**
 * A document containing one env(@http://schema.mytestbed.net/omf/6.0/protocol) element.
 *
 * This is a complex type.
 */
public class EnvDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.mytestbed.schema.omf.x60.protocol.EnvDocument
{
    private static final long serialVersionUID = 1L;
    
    public EnvDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENV$0 = 
        new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "env");
    
    
    /**
     * Gets the "env" element
     */
    public net.mytestbed.schema.omf.x60.protocol.EnvDocument.Env getEnv()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.mytestbed.schema.omf.x60.protocol.EnvDocument.Env target = null;
            target = (net.mytestbed.schema.omf.x60.protocol.EnvDocument.Env)get_store().find_element_user(ENV$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "env" element
     */
    public void setEnv(net.mytestbed.schema.omf.x60.protocol.EnvDocument.Env env)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.mytestbed.schema.omf.x60.protocol.EnvDocument.Env target = null;
            target = (net.mytestbed.schema.omf.x60.protocol.EnvDocument.Env)get_store().find_element_user(ENV$0, 0);
            if (target == null)
            {
                target = (net.mytestbed.schema.omf.x60.protocol.EnvDocument.Env)get_store().add_element_user(ENV$0);
            }
            target.set(env);
        }
    }
    
    /**
     * Appends and returns a new empty "env" element
     */
    public net.mytestbed.schema.omf.x60.protocol.EnvDocument.Env addNewEnv()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.mytestbed.schema.omf.x60.protocol.EnvDocument.Env target = null;
            target = (net.mytestbed.schema.omf.x60.protocol.EnvDocument.Env)get_store().add_element_user(ENV$0);
            return target;
        }
    }
    /**
     * An XML env(@http://schema.mytestbed.net/omf/6.0/protocol).
     *
     * This is a complex type.
     */
    public static class EnvImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.mytestbed.schema.omf.x60.protocol.EnvDocument.Env
    {
        private static final long serialVersionUID = 1L;
        
        public EnvImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CREATE$0 = 
            new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "create");
        private static final javax.xml.namespace.QName CONFIGURE$2 = 
            new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "configure");
        private static final javax.xml.namespace.QName REQUEST$4 = 
            new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "request");
        private static final javax.xml.namespace.QName RELEASE$6 = 
            new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "release");
        private static final javax.xml.namespace.QName INFORM$8 = 
            new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "inform");
        
        
        /**
         * Gets the "create" element
         */
        public net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create getCreate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create)get_store().find_element_user(CREATE$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "create" element
         */
        public boolean isSetCreate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CREATE$0) != 0;
            }
        }
        
        /**
         * Sets the "create" element
         */
        public void setCreate(net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create create)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create)get_store().find_element_user(CREATE$0, 0);
                if (target == null)
                {
                    target = (net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create)get_store().add_element_user(CREATE$0);
                }
                target.set(create);
            }
        }
        
        /**
         * Appends and returns a new empty "create" element
         */
        public net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create addNewCreate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create)get_store().add_element_user(CREATE$0);
                return target;
            }
        }
        
        /**
         * Unsets the "create" element
         */
        public void unsetCreate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CREATE$0, 0);
            }
        }
        
        /**
         * Gets the "configure" element
         */
        public net.mytestbed.schema.omf.x60.protocol.ConfigureDocument.Configure getConfigure()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.ConfigureDocument.Configure target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.ConfigureDocument.Configure)get_store().find_element_user(CONFIGURE$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "configure" element
         */
        public boolean isSetConfigure()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CONFIGURE$2) != 0;
            }
        }
        
        /**
         * Sets the "configure" element
         */
        public void setConfigure(net.mytestbed.schema.omf.x60.protocol.ConfigureDocument.Configure configure)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.ConfigureDocument.Configure target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.ConfigureDocument.Configure)get_store().find_element_user(CONFIGURE$2, 0);
                if (target == null)
                {
                    target = (net.mytestbed.schema.omf.x60.protocol.ConfigureDocument.Configure)get_store().add_element_user(CONFIGURE$2);
                }
                target.set(configure);
            }
        }
        
        /**
         * Appends and returns a new empty "configure" element
         */
        public net.mytestbed.schema.omf.x60.protocol.ConfigureDocument.Configure addNewConfigure()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.ConfigureDocument.Configure target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.ConfigureDocument.Configure)get_store().add_element_user(CONFIGURE$2);
                return target;
            }
        }
        
        /**
         * Unsets the "configure" element
         */
        public void unsetConfigure()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CONFIGURE$2, 0);
            }
        }
        
        /**
         * Gets the "request" element
         */
        public net.mytestbed.schema.omf.x60.protocol.RequestDocument.Request getRequest()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.RequestDocument.Request target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.RequestDocument.Request)get_store().find_element_user(REQUEST$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "request" element
         */
        public boolean isSetRequest()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(REQUEST$4) != 0;
            }
        }
        
        /**
         * Sets the "request" element
         */
        public void setRequest(net.mytestbed.schema.omf.x60.protocol.RequestDocument.Request request)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.RequestDocument.Request target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.RequestDocument.Request)get_store().find_element_user(REQUEST$4, 0);
                if (target == null)
                {
                    target = (net.mytestbed.schema.omf.x60.protocol.RequestDocument.Request)get_store().add_element_user(REQUEST$4);
                }
                target.set(request);
            }
        }
        
        /**
         * Appends and returns a new empty "request" element
         */
        public net.mytestbed.schema.omf.x60.protocol.RequestDocument.Request addNewRequest()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.RequestDocument.Request target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.RequestDocument.Request)get_store().add_element_user(REQUEST$4);
                return target;
            }
        }
        
        /**
         * Unsets the "request" element
         */
        public void unsetRequest()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(REQUEST$4, 0);
            }
        }
        
        /**
         * Gets the "release" element
         */
        public net.mytestbed.schema.omf.x60.protocol.ReleaseDocument.Release getRelease()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.ReleaseDocument.Release target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument.Release)get_store().find_element_user(RELEASE$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "release" element
         */
        public boolean isSetRelease()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(RELEASE$6) != 0;
            }
        }
        
        /**
         * Sets the "release" element
         */
        public void setRelease(net.mytestbed.schema.omf.x60.protocol.ReleaseDocument.Release release)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.ReleaseDocument.Release target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument.Release)get_store().find_element_user(RELEASE$6, 0);
                if (target == null)
                {
                    target = (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument.Release)get_store().add_element_user(RELEASE$6);
                }
                target.set(release);
            }
        }
        
        /**
         * Appends and returns a new empty "release" element
         */
        public net.mytestbed.schema.omf.x60.protocol.ReleaseDocument.Release addNewRelease()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.ReleaseDocument.Release target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument.Release)get_store().add_element_user(RELEASE$6);
                return target;
            }
        }
        
        /**
         * Unsets the "release" element
         */
        public void unsetRelease()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(RELEASE$6, 0);
            }
        }
        
        /**
         * Gets the "inform" element
         */
        public net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform getInform()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform)get_store().find_element_user(INFORM$8, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "inform" element
         */
        public boolean isSetInform()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(INFORM$8) != 0;
            }
        }
        
        /**
         * Sets the "inform" element
         */
        public void setInform(net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform inform)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform)get_store().find_element_user(INFORM$8, 0);
                if (target == null)
                {
                    target = (net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform)get_store().add_element_user(INFORM$8);
                }
                target.set(inform);
            }
        }
        
        /**
         * Appends and returns a new empty "inform" element
         */
        public net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform addNewInform()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform)get_store().add_element_user(INFORM$8);
                return target;
            }
        }
        
        /**
         * Unsets the "inform" element
         */
        public void unsetInform()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(INFORM$8, 0);
            }
        }
    }
}
