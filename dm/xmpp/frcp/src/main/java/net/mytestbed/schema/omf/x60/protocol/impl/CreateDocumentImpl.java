/*
 * An XML document type.
 * Localname: create
 * Namespace: http://schema.mytestbed.net/omf/6.0/protocol
 * Java type: net.mytestbed.schema.omf.x60.protocol.CreateDocument
 *
 * Automatically generated - do not modify.
 */
package net.mytestbed.schema.omf.x60.protocol.impl;
/**
 * A document containing one create(@http://schema.mytestbed.net/omf/6.0/protocol) element.
 *
 * This is a complex type.
 */
public class CreateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.mytestbed.schema.omf.x60.protocol.CreateDocument
{
    private static final long serialVersionUID = 1L;
    
    public CreateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CREATE$0 = 
        new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "create");
    
    
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
     * An XML create(@http://schema.mytestbed.net/omf/6.0/protocol).
     *
     * This is a complex type.
     */
    public static class CreateImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create
    {
        private static final long serialVersionUID = 1L;
        
        public CreateImpl(org.apache.xmlbeans.SchemaType sType)
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
        private static final javax.xml.namespace.QName RTYPE$10 = 
            new javax.xml.namespace.QName("http://schema.mytestbed.net/omf/6.0/protocol", "rtype");
        private static final javax.xml.namespace.QName MID$12 = 
            new javax.xml.namespace.QName("", "mid");
        
        
        /**
         * Gets a List of "ts" elements
         */
        public java.util.List<java.lang.String> getTsList()
        {
            final class TsList extends java.util.AbstractList<java.lang.String>
            {
                public java.lang.String get(int i)
                    { return CreateImpl.this.getTsArray(i); }
                
                public java.lang.String set(int i, java.lang.String o)
                {
                    java.lang.String old = CreateImpl.this.getTsArray(i);
                    CreateImpl.this.setTsArray(i, o);
                    return old;
                }
                
                public void add(int i, java.lang.String o)
                    { CreateImpl.this.insertTs(i, o); }
                
                public java.lang.String remove(int i)
                {
                    java.lang.String old = CreateImpl.this.getTsArray(i);
                    CreateImpl.this.removeTs(i);
                    return old;
                }
                
                public int size()
                    { return CreateImpl.this.sizeOfTsArray(); }
                
            }
            
            synchronized (monitor())
            {
                check_orphaned();
                return new TsList();
            }
        }
        
        /**
         * Gets array of all "ts" elements
         * @deprecated
         */
        public java.lang.String[] getTsArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<org.apache.xmlbeans.XmlString> targetList = new java.util.ArrayList<org.apache.xmlbeans.XmlString>();
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
         * Gets (as xml) a List of "ts" elements
         */
        public java.util.List<org.apache.xmlbeans.XmlString> xgetTsList()
        {
            final class TsList extends java.util.AbstractList<org.apache.xmlbeans.XmlString>
            {
                public org.apache.xmlbeans.XmlString get(int i)
                    { return CreateImpl.this.xgetTsArray(i); }
                
                public org.apache.xmlbeans.XmlString set(int i, org.apache.xmlbeans.XmlString o)
                {
                    org.apache.xmlbeans.XmlString old = CreateImpl.this.xgetTsArray(i);
                    CreateImpl.this.xsetTsArray(i, o);
                    return old;
                }
                
                public void add(int i, org.apache.xmlbeans.XmlString o)
                    { CreateImpl.this.insertNewTs(i).set(o); }
                
                public org.apache.xmlbeans.XmlString remove(int i)
                {
                    org.apache.xmlbeans.XmlString old = CreateImpl.this.xgetTsArray(i);
                    CreateImpl.this.removeTs(i);
                    return old;
                }
                
                public int size()
                    { return CreateImpl.this.sizeOfTsArray(); }
                
            }
            
            synchronized (monitor())
            {
                check_orphaned();
                return new TsList();
            }
        }
        
        /**
         * Gets array of all "ts" elements
         * @deprecated
         */
        public org.apache.xmlbeans.XmlString[] xgetTsArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<org.apache.xmlbeans.XmlString> targetList = new java.util.ArrayList<org.apache.xmlbeans.XmlString>();
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
         * Gets a List of "src" elements
         */
        public java.util.List<java.lang.String> getSrcList()
        {
            final class SrcList extends java.util.AbstractList<java.lang.String>
            {
                public java.lang.String get(int i)
                    { return CreateImpl.this.getSrcArray(i); }
                
                public java.lang.String set(int i, java.lang.String o)
                {
                    java.lang.String old = CreateImpl.this.getSrcArray(i);
                    CreateImpl.this.setSrcArray(i, o);
                    return old;
                }
                
                public void add(int i, java.lang.String o)
                    { CreateImpl.this.insertSrc(i, o); }
                
                public java.lang.String remove(int i)
                {
                    java.lang.String old = CreateImpl.this.getSrcArray(i);
                    CreateImpl.this.removeSrc(i);
                    return old;
                }
                
                public int size()
                    { return CreateImpl.this.sizeOfSrcArray(); }
                
            }
            
            synchronized (monitor())
            {
                check_orphaned();
                return new SrcList();
            }
        }
        
        /**
         * Gets array of all "src" elements
         * @deprecated
         */
        public java.lang.String[] getSrcArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<org.apache.xmlbeans.XmlString> targetList = new java.util.ArrayList<org.apache.xmlbeans.XmlString>();
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
         * Gets (as xml) a List of "src" elements
         */
        public java.util.List<org.apache.xmlbeans.XmlString> xgetSrcList()
        {
            final class SrcList extends java.util.AbstractList<org.apache.xmlbeans.XmlString>
            {
                public org.apache.xmlbeans.XmlString get(int i)
                    { return CreateImpl.this.xgetSrcArray(i); }
                
                public org.apache.xmlbeans.XmlString set(int i, org.apache.xmlbeans.XmlString o)
                {
                    org.apache.xmlbeans.XmlString old = CreateImpl.this.xgetSrcArray(i);
                    CreateImpl.this.xsetSrcArray(i, o);
                    return old;
                }
                
                public void add(int i, org.apache.xmlbeans.XmlString o)
                    { CreateImpl.this.insertNewSrc(i).set(o); }
                
                public org.apache.xmlbeans.XmlString remove(int i)
                {
                    org.apache.xmlbeans.XmlString old = CreateImpl.this.xgetSrcArray(i);
                    CreateImpl.this.removeSrc(i);
                    return old;
                }
                
                public int size()
                    { return CreateImpl.this.sizeOfSrcArray(); }
                
            }
            
            synchronized (monitor())
            {
                check_orphaned();
                return new SrcList();
            }
        }
        
        /**
         * Gets array of all "src" elements
         * @deprecated
         */
        public org.apache.xmlbeans.XmlString[] xgetSrcArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<org.apache.xmlbeans.XmlString> targetList = new java.util.ArrayList<org.apache.xmlbeans.XmlString>();
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
         * Gets a List of "replyto" elements
         */
        public java.util.List<java.lang.String> getReplytoList()
        {
            final class ReplytoList extends java.util.AbstractList<java.lang.String>
            {
                public java.lang.String get(int i)
                    { return CreateImpl.this.getReplytoArray(i); }
                
                public java.lang.String set(int i, java.lang.String o)
                {
                    java.lang.String old = CreateImpl.this.getReplytoArray(i);
                    CreateImpl.this.setReplytoArray(i, o);
                    return old;
                }
                
                public void add(int i, java.lang.String o)
                    { CreateImpl.this.insertReplyto(i, o); }
                
                public java.lang.String remove(int i)
                {
                    java.lang.String old = CreateImpl.this.getReplytoArray(i);
                    CreateImpl.this.removeReplyto(i);
                    return old;
                }
                
                public int size()
                    { return CreateImpl.this.sizeOfReplytoArray(); }
                
            }
            
            synchronized (monitor())
            {
                check_orphaned();
                return new ReplytoList();
            }
        }
        
        /**
         * Gets array of all "replyto" elements
         * @deprecated
         */
        public java.lang.String[] getReplytoArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<org.apache.xmlbeans.XmlString> targetList = new java.util.ArrayList<org.apache.xmlbeans.XmlString>();
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
         * Gets (as xml) a List of "replyto" elements
         */
        public java.util.List<org.apache.xmlbeans.XmlString> xgetReplytoList()
        {
            final class ReplytoList extends java.util.AbstractList<org.apache.xmlbeans.XmlString>
            {
                public org.apache.xmlbeans.XmlString get(int i)
                    { return CreateImpl.this.xgetReplytoArray(i); }
                
                public org.apache.xmlbeans.XmlString set(int i, org.apache.xmlbeans.XmlString o)
                {
                    org.apache.xmlbeans.XmlString old = CreateImpl.this.xgetReplytoArray(i);
                    CreateImpl.this.xsetReplytoArray(i, o);
                    return old;
                }
                
                public void add(int i, org.apache.xmlbeans.XmlString o)
                    { CreateImpl.this.insertNewReplyto(i).set(o); }
                
                public org.apache.xmlbeans.XmlString remove(int i)
                {
                    org.apache.xmlbeans.XmlString old = CreateImpl.this.xgetReplytoArray(i);
                    CreateImpl.this.removeReplyto(i);
                    return old;
                }
                
                public int size()
                    { return CreateImpl.this.sizeOfReplytoArray(); }
                
            }
            
            synchronized (monitor())
            {
                check_orphaned();
                return new ReplytoList();
            }
        }
        
        /**
         * Gets array of all "replyto" elements
         * @deprecated
         */
        public org.apache.xmlbeans.XmlString[] xgetReplytoArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<org.apache.xmlbeans.XmlString> targetList = new java.util.ArrayList<org.apache.xmlbeans.XmlString>();
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
         * Gets a List of "props" elements
         */
        public java.util.List<net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props> getPropsList()
        {
            final class PropsList extends java.util.AbstractList<net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props>
            {
                public net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props get(int i)
                    { return CreateImpl.this.getPropsArray(i); }
                
                public net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props set(int i, net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props o)
                {
                    net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props old = CreateImpl.this.getPropsArray(i);
                    CreateImpl.this.setPropsArray(i, o);
                    return old;
                }
                
                public void add(int i, net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props o)
                    { CreateImpl.this.insertNewProps(i).set(o); }
                
                public net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props remove(int i)
                {
                    net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props old = CreateImpl.this.getPropsArray(i);
                    CreateImpl.this.removeProps(i);
                    return old;
                }
                
                public int size()
                    { return CreateImpl.this.sizeOfPropsArray(); }
                
            }
            
            synchronized (monitor())
            {
                check_orphaned();
                return new PropsList();
            }
        }
        
        /**
         * Gets array of all "props" elements
         * @deprecated
         */
        public net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props[] getPropsArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props> targetList = new java.util.ArrayList<net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props>();
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
         * Gets a List of "guard" elements
         */
        public java.util.List<net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard> getGuardList()
        {
            final class GuardList extends java.util.AbstractList<net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard>
            {
                public net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard get(int i)
                    { return CreateImpl.this.getGuardArray(i); }
                
                public net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard set(int i, net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard o)
                {
                    net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard old = CreateImpl.this.getGuardArray(i);
                    CreateImpl.this.setGuardArray(i, o);
                    return old;
                }
                
                public void add(int i, net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard o)
                    { CreateImpl.this.insertNewGuard(i).set(o); }
                
                public net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard remove(int i)
                {
                    net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard old = CreateImpl.this.getGuardArray(i);
                    CreateImpl.this.removeGuard(i);
                    return old;
                }
                
                public int size()
                    { return CreateImpl.this.sizeOfGuardArray(); }
                
            }
            
            synchronized (monitor())
            {
                check_orphaned();
                return new GuardList();
            }
        }
        
        /**
         * Gets array of all "guard" elements
         * @deprecated
         */
        public net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard[] getGuardArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard> targetList = new java.util.ArrayList<net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard>();
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
         * Gets a List of "rtype" elements
         */
        public java.util.List<java.lang.String> getRtypeList()
        {
            final class RtypeList extends java.util.AbstractList<java.lang.String>
            {
                public java.lang.String get(int i)
                    { return CreateImpl.this.getRtypeArray(i); }
                
                public java.lang.String set(int i, java.lang.String o)
                {
                    java.lang.String old = CreateImpl.this.getRtypeArray(i);
                    CreateImpl.this.setRtypeArray(i, o);
                    return old;
                }
                
                public void add(int i, java.lang.String o)
                    { CreateImpl.this.insertRtype(i, o); }
                
                public java.lang.String remove(int i)
                {
                    java.lang.String old = CreateImpl.this.getRtypeArray(i);
                    CreateImpl.this.removeRtype(i);
                    return old;
                }
                
                public int size()
                    { return CreateImpl.this.sizeOfRtypeArray(); }
                
            }
            
            synchronized (monitor())
            {
                check_orphaned();
                return new RtypeList();
            }
        }
        
        /**
         * Gets array of all "rtype" elements
         * @deprecated
         */
        public java.lang.String[] getRtypeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<org.apache.xmlbeans.XmlString> targetList = new java.util.ArrayList<org.apache.xmlbeans.XmlString>();
                get_store().find_all_element_users(RTYPE$10, targetList);
                java.lang.String[] result = new java.lang.String[targetList.size()];
                for (int i = 0, len = targetList.size() ; i < len ; i++)
                    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
                return result;
            }
        }
        
        /**
         * Gets ith "rtype" element
         */
        public java.lang.String getRtypeArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RTYPE$10, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) a List of "rtype" elements
         */
        public java.util.List<org.apache.xmlbeans.XmlString> xgetRtypeList()
        {
            final class RtypeList extends java.util.AbstractList<org.apache.xmlbeans.XmlString>
            {
                public org.apache.xmlbeans.XmlString get(int i)
                    { return CreateImpl.this.xgetRtypeArray(i); }
                
                public org.apache.xmlbeans.XmlString set(int i, org.apache.xmlbeans.XmlString o)
                {
                    org.apache.xmlbeans.XmlString old = CreateImpl.this.xgetRtypeArray(i);
                    CreateImpl.this.xsetRtypeArray(i, o);
                    return old;
                }
                
                public void add(int i, org.apache.xmlbeans.XmlString o)
                    { CreateImpl.this.insertNewRtype(i).set(o); }
                
                public org.apache.xmlbeans.XmlString remove(int i)
                {
                    org.apache.xmlbeans.XmlString old = CreateImpl.this.xgetRtypeArray(i);
                    CreateImpl.this.removeRtype(i);
                    return old;
                }
                
                public int size()
                    { return CreateImpl.this.sizeOfRtypeArray(); }
                
            }
            
            synchronized (monitor())
            {
                check_orphaned();
                return new RtypeList();
            }
        }
        
        /**
         * Gets array of all "rtype" elements
         * @deprecated
         */
        public org.apache.xmlbeans.XmlString[] xgetRtypeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<org.apache.xmlbeans.XmlString> targetList = new java.util.ArrayList<org.apache.xmlbeans.XmlString>();
                get_store().find_all_element_users(RTYPE$10, targetList);
                org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets (as xml) ith "rtype" element
         */
        public org.apache.xmlbeans.XmlString xgetRtypeArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RTYPE$10, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return (org.apache.xmlbeans.XmlString)target;
            }
        }
        
        /**
         * Returns number of "rtype" element
         */
        public int sizeOfRtypeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(RTYPE$10);
            }
        }
        
        /**
         * Sets array of all "rtype" element
         */
        public void setRtypeArray(java.lang.String[] rtypeArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(rtypeArray, RTYPE$10);
            }
        }
        
        /**
         * Sets ith "rtype" element
         */
        public void setRtypeArray(int i, java.lang.String rtype)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RTYPE$10, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.setStringValue(rtype);
            }
        }
        
        /**
         * Sets (as xml) array of all "rtype" element
         */
        public void xsetRtypeArray(org.apache.xmlbeans.XmlString[]rtypeArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(rtypeArray, RTYPE$10);
            }
        }
        
        /**
         * Sets (as xml) ith "rtype" element
         */
        public void xsetRtypeArray(int i, org.apache.xmlbeans.XmlString rtype)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RTYPE$10, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(rtype);
            }
        }
        
        /**
         * Inserts the value as the ith "rtype" element
         */
        public void insertRtype(int i, java.lang.String rtype)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = 
                    (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(RTYPE$10, i);
                target.setStringValue(rtype);
            }
        }
        
        /**
         * Appends the value as the last "rtype" element
         */
        public void addRtype(java.lang.String rtype)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RTYPE$10);
                target.setStringValue(rtype);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "rtype" element
         */
        public org.apache.xmlbeans.XmlString insertNewRtype(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(RTYPE$10, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "rtype" element
         */
        public org.apache.xmlbeans.XmlString addNewRtype()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(RTYPE$10);
                return target;
            }
        }
        
        /**
         * Removes the ith "rtype" element
         */
        public void removeRtype(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(RTYPE$10, i);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MID$12);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(MID$12);
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
                return get_store().find_attribute_user(MID$12) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MID$12);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(MID$12);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(MID$12);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(MID$12);
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
                get_store().remove_attribute(MID$12);
            }
        }
    }
}
