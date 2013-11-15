/*
 * An XML document type.
 * Localname: inform
 * Namespace: http://schema.mytestbed.net/omf/6.0/protocol
 * Java type: net.mytestbed.schema.omf.x60.protocol.InformDocument
 *
 * Automatically generated - do not modify.
 */
package net.mytestbed.schema.omf.x60.protocol.impl;
/**
 * A document containing one inform(@http://schema.mytestbed.net/omf/6.0/protocol) element.
 *
 * This is a complex type.
 */
public class InformDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.mytestbed.schema.omf.x60.protocol.InformDocument
{
    private static final long serialVersionUID = 1L;
    
    public InformDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INFORM$0 = 
        new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "inform");
    
    
    /**
     * Gets the "inform" element
     */
    public net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform getInform()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform target = null;
            target = (net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform)get_store().find_element_user(INFORM$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
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
            target = (net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform)get_store().find_element_user(INFORM$0, 0);
            if (target == null)
            {
                target = (net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform)get_store().add_element_user(INFORM$0);
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
            target = (net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform)get_store().add_element_user(INFORM$0);
            return target;
        }
    }
    /**
     * An XML inform(@http://schema.mytestbed.net/omf/6.0/protocol).
     *
     * This is a complex type.
     */
    public static class InformImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform
    {
        private static final long serialVersionUID = 1L;
        
        public InformImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName TS$0 = 
            new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "ts");
        private static final javax.xml.namespace.QName SRC$2 = 
            new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "src");
        private static final javax.xml.namespace.QName REPLYTO$4 = 
            new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "replyto");
        private static final javax.xml.namespace.QName PROPS$6 = 
            new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "props");
        private static final javax.xml.namespace.QName GUARD$8 = 
            new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "guard");
        private static final javax.xml.namespace.QName CID$10 = 
            new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "cid");
        private static final javax.xml.namespace.QName ITYPE$12 = 
            new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "itype");
        private static final javax.xml.namespace.QName MID$14 = 
            new javax.xml.namespace.QName("", "mid");
        
        
        /**
         * Gets array of all "ts" elements
         */
        public java.lang.String[] getTsArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(TS$0, targetList);
                java.lang.String[] result = new java.lang.String[targetList.size()];
                for (int i = 0, len = targetList.size() ; i < len ; i++)
                    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
                return result;
            }
        }
        
        /**
         * Gets ith "ts" element
         */
        public java.lang.String getTsArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TS$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) array of all "ts" elements
         */
        public org.apache.xmlbeans.XmlString[] xgetTsArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(TS$0, targetList);
                org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets (as xml) ith "ts" element
         */
        public org.apache.xmlbeans.XmlString xgetTsArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TS$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return (org.apache.xmlbeans.XmlString)target;
            }
        }
        
        /**
         * Returns number of "ts" element
         */
        public int sizeOfTsArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(TS$0);
            }
        }
        
        /**
         * Sets array of all "ts" element
         */
        public void setTsArray(java.lang.String[] tsArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(tsArray, TS$0);
            }
        }
        
        /**
         * Sets ith "ts" element
         */
        public void setTsArray(int i, java.lang.String ts)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TS$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.setStringValue(ts);
            }
        }
        
        /**
         * Sets (as xml) array of all "ts" element
         */
        public void xsetTsArray(org.apache.xmlbeans.XmlString[]tsArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(tsArray, TS$0);
            }
        }
        
        /**
         * Sets (as xml) ith "ts" element
         */
        public void xsetTsArray(int i, org.apache.xmlbeans.XmlString ts)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TS$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(ts);
            }
        }
        
        /**
         * Inserts the value as the ith "ts" element
         */
        public void insertTs(int i, java.lang.String ts)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = 
                    (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(TS$0, i);
                target.setStringValue(ts);
            }
        }
        
        /**
         * Appends the value as the last "ts" element
         */
        public void addTs(java.lang.String ts)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TS$0);
                target.setStringValue(ts);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "ts" element
         */
        public org.apache.xmlbeans.XmlString insertNewTs(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(TS$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "ts" element
         */
        public org.apache.xmlbeans.XmlString addNewTs()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TS$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "ts" element
         */
        public void removeTs(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(TS$0, i);
            }
        }
        
        /**
         * Gets array of all "src" elements
         */
        public java.lang.String[] getSrcArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(SRC$2, targetList);
                java.lang.String[] result = new java.lang.String[targetList.size()];
                for (int i = 0, len = targetList.size() ; i < len ; i++)
                    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
                return result;
            }
        }
        
        /**
         * Gets ith "src" element
         */
        public java.lang.String getSrcArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SRC$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) array of all "src" elements
         */
        public org.apache.xmlbeans.XmlString[] xgetSrcArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(SRC$2, targetList);
                org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets (as xml) ith "src" element
         */
        public org.apache.xmlbeans.XmlString xgetSrcArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SRC$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return (org.apache.xmlbeans.XmlString)target;
            }
        }
        
        /**
         * Returns number of "src" element
         */
        public int sizeOfSrcArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(SRC$2);
            }
        }
        
        /**
         * Sets array of all "src" element
         */
        public void setSrcArray(java.lang.String[] srcArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(srcArray, SRC$2);
            }
        }
        
        /**
         * Sets ith "src" element
         */
        public void setSrcArray(int i, java.lang.String src)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SRC$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.setStringValue(src);
            }
        }
        
        /**
         * Sets (as xml) array of all "src" element
         */
        public void xsetSrcArray(org.apache.xmlbeans.XmlString[]srcArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(srcArray, SRC$2);
            }
        }
        
        /**
         * Sets (as xml) ith "src" element
         */
        public void xsetSrcArray(int i, org.apache.xmlbeans.XmlString src)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SRC$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(src);
            }
        }
        
        /**
         * Inserts the value as the ith "src" element
         */
        public void insertSrc(int i, java.lang.String src)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = 
                    (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(SRC$2, i);
                target.setStringValue(src);
            }
        }
        
        /**
         * Appends the value as the last "src" element
         */
        public void addSrc(java.lang.String src)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SRC$2);
                target.setStringValue(src);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "src" element
         */
        public org.apache.xmlbeans.XmlString insertNewSrc(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(SRC$2, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "src" element
         */
        public org.apache.xmlbeans.XmlString addNewSrc()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SRC$2);
                return target;
            }
        }
        
        /**
         * Removes the ith "src" element
         */
        public void removeSrc(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(SRC$2, i);
            }
        }
        
        /**
         * Gets array of all "replyto" elements
         */
        public java.lang.String[] getReplytoArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(REPLYTO$4, targetList);
                java.lang.String[] result = new java.lang.String[targetList.size()];
                for (int i = 0, len = targetList.size() ; i < len ; i++)
                    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
                return result;
            }
        }
        
        /**
         * Gets ith "replyto" element
         */
        public java.lang.String getReplytoArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REPLYTO$4, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) array of all "replyto" elements
         */
        public org.apache.xmlbeans.XmlString[] xgetReplytoArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(REPLYTO$4, targetList);
                org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets (as xml) ith "replyto" element
         */
        public org.apache.xmlbeans.XmlString xgetReplytoArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REPLYTO$4, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return (org.apache.xmlbeans.XmlString)target;
            }
        }
        
        /**
         * Returns number of "replyto" element
         */
        public int sizeOfReplytoArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(REPLYTO$4);
            }
        }
        
        /**
         * Sets array of all "replyto" element
         */
        public void setReplytoArray(java.lang.String[] replytoArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(replytoArray, REPLYTO$4);
            }
        }
        
        /**
         * Sets ith "replyto" element
         */
        public void setReplytoArray(int i, java.lang.String replyto)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REPLYTO$4, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.setStringValue(replyto);
            }
        }
        
        /**
         * Sets (as xml) array of all "replyto" element
         */
        public void xsetReplytoArray(org.apache.xmlbeans.XmlString[]replytoArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(replytoArray, REPLYTO$4);
            }
        }
        
        /**
         * Sets (as xml) ith "replyto" element
         */
        public void xsetReplytoArray(int i, org.apache.xmlbeans.XmlString replyto)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REPLYTO$4, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(replyto);
            }
        }
        
        /**
         * Inserts the value as the ith "replyto" element
         */
        public void insertReplyto(int i, java.lang.String replyto)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = 
                    (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(REPLYTO$4, i);
                target.setStringValue(replyto);
            }
        }
        
        /**
         * Appends the value as the last "replyto" element
         */
        public void addReplyto(java.lang.String replyto)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REPLYTO$4);
                target.setStringValue(replyto);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "replyto" element
         */
        public org.apache.xmlbeans.XmlString insertNewReplyto(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(REPLYTO$4, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "replyto" element
         */
        public org.apache.xmlbeans.XmlString addNewReplyto()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(REPLYTO$4);
                return target;
            }
        }
        
        /**
         * Removes the ith "replyto" element
         */
        public void removeReplyto(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(REPLYTO$4, i);
            }
        }
        
        /**
         * Gets array of all "props" elements
         */
        public net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props[] getPropsArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(PROPS$6, targetList);
                net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props[] result = new net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "props" element
         */
        public net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props getPropsArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props)get_store().find_element_user(PROPS$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "props" element
         */
        public int sizeOfPropsArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(PROPS$6);
            }
        }
        
        /**
         * Sets array of all "props" element
         */
        public void setPropsArray(net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props[] propsArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(propsArray, PROPS$6);
            }
        }
        
        /**
         * Sets ith "props" element
         */
        public void setPropsArray(int i, net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props props)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props)get_store().find_element_user(PROPS$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(props);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "props" element
         */
        public net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props insertNewProps(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props)get_store().insert_element_user(PROPS$6, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "props" element
         */
        public net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props addNewProps()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props)get_store().add_element_user(PROPS$6);
                return target;
            }
        }
        
        /**
         * Removes the ith "props" element
         */
        public void removeProps(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(PROPS$6, i);
            }
        }
        
        /**
         * Gets array of all "guard" elements
         */
        public net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard[] getGuardArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(GUARD$8, targetList);
                net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard[] result = new net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "guard" element
         */
        public net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard getGuardArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard)get_store().find_element_user(GUARD$8, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "guard" element
         */
        public int sizeOfGuardArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(GUARD$8);
            }
        }
        
        /**
         * Sets array of all "guard" element
         */
        public void setGuardArray(net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard[] guardArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(guardArray, GUARD$8);
            }
        }
        
        /**
         * Sets ith "guard" element
         */
        public void setGuardArray(int i, net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard guard)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard)get_store().find_element_user(GUARD$8, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(guard);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "guard" element
         */
        public net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard insertNewGuard(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard)get_store().insert_element_user(GUARD$8, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "guard" element
         */
        public net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard addNewGuard()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard)get_store().add_element_user(GUARD$8);
                return target;
            }
        }
        
        /**
         * Removes the ith "guard" element
         */
        public void removeGuard(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(GUARD$8, i);
            }
        }
        
        /**
         * Gets array of all "cid" elements
         */
        public java.lang.String[] getCidArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(CID$10, targetList);
                java.lang.String[] result = new java.lang.String[targetList.size()];
                for (int i = 0, len = targetList.size() ; i < len ; i++)
                    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
                return result;
            }
        }
        
        /**
         * Gets ith "cid" element
         */
        public java.lang.String getCidArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CID$10, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) array of all "cid" elements
         */
        public org.apache.xmlbeans.XmlString[] xgetCidArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(CID$10, targetList);
                org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets (as xml) ith "cid" element
         */
        public org.apache.xmlbeans.XmlString xgetCidArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CID$10, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return (org.apache.xmlbeans.XmlString)target;
            }
        }
        
        /**
         * Returns number of "cid" element
         */
        public int sizeOfCidArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CID$10);
            }
        }
        
        /**
         * Sets array of all "cid" element
         */
        public void setCidArray(java.lang.String[] cidArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(cidArray, CID$10);
            }
        }
        
        /**
         * Sets ith "cid" element
         */
        public void setCidArray(int i, java.lang.String cid)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CID$10, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.setStringValue(cid);
            }
        }
        
        /**
         * Sets (as xml) array of all "cid" element
         */
        public void xsetCidArray(org.apache.xmlbeans.XmlString[]cidArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(cidArray, CID$10);
            }
        }
        
        /**
         * Sets (as xml) ith "cid" element
         */
        public void xsetCidArray(int i, org.apache.xmlbeans.XmlString cid)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CID$10, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(cid);
            }
        }
        
        /**
         * Inserts the value as the ith "cid" element
         */
        public void insertCid(int i, java.lang.String cid)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = 
                    (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(CID$10, i);
                target.setStringValue(cid);
            }
        }
        
        /**
         * Appends the value as the last "cid" element
         */
        public void addCid(java.lang.String cid)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CID$10);
                target.setStringValue(cid);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "cid" element
         */
        public org.apache.xmlbeans.XmlString insertNewCid(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(CID$10, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "cid" element
         */
        public org.apache.xmlbeans.XmlString addNewCid()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CID$10);
                return target;
            }
        }
        
        /**
         * Removes the ith "cid" element
         */
        public void removeCid(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CID$10, i);
            }
        }
        
        /**
         * Gets array of all "itype" elements
         */
        public net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum[] getItypeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(ITYPE$12, targetList);
                net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum[] result = new net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum[targetList.size()];
                for (int i = 0, len = targetList.size() ; i < len ; i++)
                    result[i] = (net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum)((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getEnumValue();
                return result;
            }
        }
        
        /**
         * Gets ith "itype" element
         */
        public net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum getItypeArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ITYPE$12, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) array of all "itype" elements
         */
        public net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype[] xgetItypeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(ITYPE$12, targetList);
                net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype[] result = new net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets (as xml) ith "itype" element
         */
        public net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype xgetItypeArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype)get_store().find_element_user(ITYPE$12, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype)target;
            }
        }
        
        /**
         * Returns number of "itype" element
         */
        public int sizeOfItypeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ITYPE$12);
            }
        }
        
        /**
         * Sets array of all "itype" element
         */
        public void setItypeArray(net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum[] itypeArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(itypeArray, ITYPE$12);
            }
        }
        
        /**
         * Sets ith "itype" element
         */
        public void setItypeArray(int i, net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum itype)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ITYPE$12, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.setEnumValue(itype);
            }
        }
        
        /**
         * Sets (as xml) array of all "itype" element
         */
        public void xsetItypeArray(net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype[]itypeArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(itypeArray, ITYPE$12);
            }
        }
        
        /**
         * Sets (as xml) ith "itype" element
         */
        public void xsetItypeArray(int i, net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype itype)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype)get_store().find_element_user(ITYPE$12, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(itype);
            }
        }
        
        /**
         * Inserts the value as the ith "itype" element
         */
        public void insertItype(int i, net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum itype)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = 
                    (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(ITYPE$12, i);
                target.setEnumValue(itype);
            }
        }
        
        /**
         * Appends the value as the last "itype" element
         */
        public void addItype(net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum itype)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ITYPE$12);
                target.setEnumValue(itype);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "itype" element
         */
        public net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype insertNewItype(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype)get_store().insert_element_user(ITYPE$12, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "itype" element
         */
        public net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype addNewItype()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype target = null;
                target = (net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype)get_store().add_element_user(ITYPE$12);
                return target;
            }
        }
        
        /**
         * Removes the ith "itype" element
         */
        public void removeItype(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ITYPE$12, i);
            }
        }
        
        /**
         * Gets the "mid" attribute
         */
        public java.lang.String getMid()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MID$14);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "mid" attribute
         */
        public org.apache.xmlbeans.XmlString xgetMid()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(MID$14);
                return target;
            }
        }
        
        /**
         * True if has "mid" attribute
         */
        public boolean isSetMid()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(MID$14) != null;
            }
        }
        
        /**
         * Sets the "mid" attribute
         */
        public void setMid(java.lang.String mid)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MID$14);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(MID$14);
                }
                target.setStringValue(mid);
            }
        }
        
        /**
         * Sets (as xml) the "mid" attribute
         */
        public void xsetMid(org.apache.xmlbeans.XmlString mid)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(MID$14);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(MID$14);
                }
                target.set(mid);
            }
        }
        
        /**
         * Unsets the "mid" attribute
         */
        public void unsetMid()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(MID$14);
            }
        }
    }
}
