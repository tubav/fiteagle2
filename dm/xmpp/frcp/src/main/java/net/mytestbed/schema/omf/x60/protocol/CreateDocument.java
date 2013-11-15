/*
 * An XML document type.
 * Localname: create
 * Namespace: http://schema.mytestbed.net/omf/6.0/protocol
 * Java type: net.mytestbed.schema.omf.x60.protocol.CreateDocument
 *
 * Automatically generated - do not modify.
 */
package net.mytestbed.schema.omf.x60.protocol;


/**
 * A document containing one create(@http://schema.mytestbed.net/omf/6.0/protocol) element.
 *
 * This is a complex type.
 */
public interface CreateDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CreateDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD09C80FBB114BA180EC1CB4846999213").resolveHandle("createb539doctype");
    
    /**
     * Gets the "create" element
     */
    net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create getCreate();
    
    /**
     * Sets the "create" element
     */
    void setCreate(net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create create);
    
    /**
     * Appends and returns a new empty "create" element
     */
    net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create addNewCreate();
    
    /**
     * An XML create(@http://schema.mytestbed.net/omf/6.0/protocol).
     *
     * This is a complex type.
     */
    public interface Create extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Create.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD09C80FBB114BA180EC1CB4846999213").resolveHandle("createead1elemtype");
        
        /**
         * Gets array of all "ts" elements
         */
        java.lang.String[] getTsArray();
        
        /**
         * Gets ith "ts" element
         */
        java.lang.String getTsArray(int i);
        
        /**
         * Gets (as xml) array of all "ts" elements
         */
        org.apache.xmlbeans.XmlString[] xgetTsArray();
        
        /**
         * Gets (as xml) ith "ts" element
         */
        org.apache.xmlbeans.XmlString xgetTsArray(int i);
        
        /**
         * Returns number of "ts" element
         */
        int sizeOfTsArray();
        
        /**
         * Sets array of all "ts" element
         */
        void setTsArray(java.lang.String[] tsArray);
        
        /**
         * Sets ith "ts" element
         */
        void setTsArray(int i, java.lang.String ts);
        
        /**
         * Sets (as xml) array of all "ts" element
         */
        void xsetTsArray(org.apache.xmlbeans.XmlString[] tsArray);
        
        /**
         * Sets (as xml) ith "ts" element
         */
        void xsetTsArray(int i, org.apache.xmlbeans.XmlString ts);
        
        /**
         * Inserts the value as the ith "ts" element
         */
        void insertTs(int i, java.lang.String ts);
        
        /**
         * Appends the value as the last "ts" element
         */
        void addTs(java.lang.String ts);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "ts" element
         */
        org.apache.xmlbeans.XmlString insertNewTs(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "ts" element
         */
        org.apache.xmlbeans.XmlString addNewTs();
        
        /**
         * Removes the ith "ts" element
         */
        void removeTs(int i);
        
        /**
         * Gets array of all "src" elements
         */
        java.lang.String[] getSrcArray();
        
        /**
         * Gets ith "src" element
         */
        java.lang.String getSrcArray(int i);
        
        /**
         * Gets (as xml) array of all "src" elements
         */
        org.apache.xmlbeans.XmlString[] xgetSrcArray();
        
        /**
         * Gets (as xml) ith "src" element
         */
        org.apache.xmlbeans.XmlString xgetSrcArray(int i);
        
        /**
         * Returns number of "src" element
         */
        int sizeOfSrcArray();
        
        /**
         * Sets array of all "src" element
         */
        void setSrcArray(java.lang.String[] srcArray);
        
        /**
         * Sets ith "src" element
         */
        void setSrcArray(int i, java.lang.String src);
        
        /**
         * Sets (as xml) array of all "src" element
         */
        void xsetSrcArray(org.apache.xmlbeans.XmlString[] srcArray);
        
        /**
         * Sets (as xml) ith "src" element
         */
        void xsetSrcArray(int i, org.apache.xmlbeans.XmlString src);
        
        /**
         * Inserts the value as the ith "src" element
         */
        void insertSrc(int i, java.lang.String src);
        
        /**
         * Appends the value as the last "src" element
         */
        void addSrc(java.lang.String src);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "src" element
         */
        org.apache.xmlbeans.XmlString insertNewSrc(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "src" element
         */
        org.apache.xmlbeans.XmlString addNewSrc();
        
        /**
         * Removes the ith "src" element
         */
        void removeSrc(int i);
        
        /**
         * Gets array of all "replyto" elements
         */
        java.lang.String[] getReplytoArray();
        
        /**
         * Gets ith "replyto" element
         */
        java.lang.String getReplytoArray(int i);
        
        /**
         * Gets (as xml) array of all "replyto" elements
         */
        org.apache.xmlbeans.XmlString[] xgetReplytoArray();
        
        /**
         * Gets (as xml) ith "replyto" element
         */
        org.apache.xmlbeans.XmlString xgetReplytoArray(int i);
        
        /**
         * Returns number of "replyto" element
         */
        int sizeOfReplytoArray();
        
        /**
         * Sets array of all "replyto" element
         */
        void setReplytoArray(java.lang.String[] replytoArray);
        
        /**
         * Sets ith "replyto" element
         */
        void setReplytoArray(int i, java.lang.String replyto);
        
        /**
         * Sets (as xml) array of all "replyto" element
         */
        void xsetReplytoArray(org.apache.xmlbeans.XmlString[] replytoArray);
        
        /**
         * Sets (as xml) ith "replyto" element
         */
        void xsetReplytoArray(int i, org.apache.xmlbeans.XmlString replyto);
        
        /**
         * Inserts the value as the ith "replyto" element
         */
        void insertReplyto(int i, java.lang.String replyto);
        
        /**
         * Appends the value as the last "replyto" element
         */
        void addReplyto(java.lang.String replyto);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "replyto" element
         */
        org.apache.xmlbeans.XmlString insertNewReplyto(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "replyto" element
         */
        org.apache.xmlbeans.XmlString addNewReplyto();
        
        /**
         * Removes the ith "replyto" element
         */
        void removeReplyto(int i);
        
        /**
         * Gets array of all "props" elements
         */
        net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props[] getPropsArray();
        
        /**
         * Gets ith "props" element
         */
        net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props getPropsArray(int i);
        
        /**
         * Returns number of "props" element
         */
        int sizeOfPropsArray();
        
        /**
         * Sets array of all "props" element
         */
        void setPropsArray(net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props[] propsArray);
        
        /**
         * Sets ith "props" element
         */
        void setPropsArray(int i, net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props props);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "props" element
         */
        net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props insertNewProps(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "props" element
         */
        net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props addNewProps();
        
        /**
         * Removes the ith "props" element
         */
        void removeProps(int i);
        
        /**
         * Gets array of all "guard" elements
         */
        net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard[] getGuardArray();
        
        /**
         * Gets ith "guard" element
         */
        net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard getGuardArray(int i);
        
        /**
         * Returns number of "guard" element
         */
        int sizeOfGuardArray();
        
        /**
         * Sets array of all "guard" element
         */
        void setGuardArray(net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard[] guardArray);
        
        /**
         * Sets ith "guard" element
         */
        void setGuardArray(int i, net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard guard);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "guard" element
         */
        net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard insertNewGuard(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "guard" element
         */
        net.mytestbed.schema.omf.x60.protocol.GuardDocument.Guard addNewGuard();
        
        /**
         * Removes the ith "guard" element
         */
        void removeGuard(int i);
        
        /**
         * Gets array of all "rtype" elements
         */
        java.lang.String[] getRtypeArray();
        
        /**
         * Gets ith "rtype" element
         */
        java.lang.String getRtypeArray(int i);
        
        /**
         * Gets (as xml) array of all "rtype" elements
         */
        org.apache.xmlbeans.XmlString[] xgetRtypeArray();
        
        /**
         * Gets (as xml) ith "rtype" element
         */
        org.apache.xmlbeans.XmlString xgetRtypeArray(int i);
        
        /**
         * Returns number of "rtype" element
         */
        int sizeOfRtypeArray();
        
        /**
         * Sets array of all "rtype" element
         */
        void setRtypeArray(java.lang.String[] rtypeArray);
        
        /**
         * Sets ith "rtype" element
         */
        void setRtypeArray(int i, java.lang.String rtype);
        
        /**
         * Sets (as xml) array of all "rtype" element
         */
        void xsetRtypeArray(org.apache.xmlbeans.XmlString[] rtypeArray);
        
        /**
         * Sets (as xml) ith "rtype" element
         */
        void xsetRtypeArray(int i, org.apache.xmlbeans.XmlString rtype);
        
        /**
         * Inserts the value as the ith "rtype" element
         */
        void insertRtype(int i, java.lang.String rtype);
        
        /**
         * Appends the value as the last "rtype" element
         */
        void addRtype(java.lang.String rtype);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "rtype" element
         */
        org.apache.xmlbeans.XmlString insertNewRtype(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "rtype" element
         */
        org.apache.xmlbeans.XmlString addNewRtype();
        
        /**
         * Removes the ith "rtype" element
         */
        void removeRtype(int i);
        
        /**
         * Gets the "mid" attribute
         */
        java.lang.String getMid();
        
        /**
         * Gets (as xml) the "mid" attribute
         */
        org.apache.xmlbeans.XmlString xgetMid();
        
        /**
         * True if has "mid" attribute
         */
        boolean isSetMid();
        
        /**
         * Sets the "mid" attribute
         */
        void setMid(java.lang.String mid);
        
        /**
         * Sets (as xml) the "mid" attribute
         */
        void xsetMid(org.apache.xmlbeans.XmlString mid);
        
        /**
         * Unsets the "mid" attribute
         */
        void unsetMid();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create newInstance() {
              return (net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument newInstance() {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.mytestbed.schema.omf.x60.protocol.CreateDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.mytestbed.schema.omf.x60.protocol.CreateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
