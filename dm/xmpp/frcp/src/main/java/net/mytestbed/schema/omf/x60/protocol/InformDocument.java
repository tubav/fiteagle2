/*
 * An XML document type.
 * Localname: inform
 * Namespace: http://schema.mytestbed.net/omf/6.0/protocol
 * Java type: net.mytestbed.schema.omf.x60.protocol.InformDocument
 *
 * Automatically generated - do not modify.
 */
package net.mytestbed.schema.omf.x60.protocol;


/**
 * A document containing one inform(@http://schema.mytestbed.net/omf/6.0/protocol) element.
 *
 * This is a complex type.
 */
public interface InformDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(InformDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD09C80FBB114BA180EC1CB4846999213").resolveHandle("inform63ecdoctype");
    
    /**
     * Gets the "inform" element
     */
    net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform getInform();
    
    /**
     * Sets the "inform" element
     */
    void setInform(net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform inform);
    
    /**
     * Appends and returns a new empty "inform" element
     */
    net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform addNewInform();
    
    /**
     * An XML inform(@http://schema.mytestbed.net/omf/6.0/protocol).
     *
     * This is a complex type.
     */
    public interface Inform extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Inform.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD09C80FBB114BA180EC1CB4846999213").resolveHandle("informc431elemtype");
        
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
         * Gets array of all "cid" elements
         */
        java.lang.String[] getCidArray();
        
        /**
         * Gets ith "cid" element
         */
        java.lang.String getCidArray(int i);
        
        /**
         * Gets (as xml) array of all "cid" elements
         */
        org.apache.xmlbeans.XmlString[] xgetCidArray();
        
        /**
         * Gets (as xml) ith "cid" element
         */
        org.apache.xmlbeans.XmlString xgetCidArray(int i);
        
        /**
         * Returns number of "cid" element
         */
        int sizeOfCidArray();
        
        /**
         * Sets array of all "cid" element
         */
        void setCidArray(java.lang.String[] cidArray);
        
        /**
         * Sets ith "cid" element
         */
        void setCidArray(int i, java.lang.String cid);
        
        /**
         * Sets (as xml) array of all "cid" element
         */
        void xsetCidArray(org.apache.xmlbeans.XmlString[] cidArray);
        
        /**
         * Sets (as xml) ith "cid" element
         */
        void xsetCidArray(int i, org.apache.xmlbeans.XmlString cid);
        
        /**
         * Inserts the value as the ith "cid" element
         */
        void insertCid(int i, java.lang.String cid);
        
        /**
         * Appends the value as the last "cid" element
         */
        void addCid(java.lang.String cid);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "cid" element
         */
        org.apache.xmlbeans.XmlString insertNewCid(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "cid" element
         */
        org.apache.xmlbeans.XmlString addNewCid();
        
        /**
         * Removes the ith "cid" element
         */
        void removeCid(int i);
        
        /**
         * Gets array of all "itype" elements
         */
        net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum[] getItypeArray();
        
        /**
         * Gets ith "itype" element
         */
        net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum getItypeArray(int i);
        
        /**
         * Gets (as xml) array of all "itype" elements
         */
        net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype[] xgetItypeArray();
        
        /**
         * Gets (as xml) ith "itype" element
         */
        net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype xgetItypeArray(int i);
        
        /**
         * Returns number of "itype" element
         */
        int sizeOfItypeArray();
        
        /**
         * Sets array of all "itype" element
         */
        void setItypeArray(net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum[] itypeArray);
        
        /**
         * Sets ith "itype" element
         */
        void setItypeArray(int i, net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum itype);
        
        /**
         * Sets (as xml) array of all "itype" element
         */
        void xsetItypeArray(net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype[] itypeArray);
        
        /**
         * Sets (as xml) ith "itype" element
         */
        void xsetItypeArray(int i, net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype itype);
        
        /**
         * Inserts the value as the ith "itype" element
         */
        void insertItype(int i, net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum itype);
        
        /**
         * Appends the value as the last "itype" element
         */
        void addItype(net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum itype);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "itype" element
         */
        net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype insertNewItype(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "itype" element
         */
        net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype addNewItype();
        
        /**
         * Removes the ith "itype" element
         */
        void removeItype(int i);
        
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
            public static net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform newInstance() {
              return (net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument newInstance() {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.mytestbed.schema.omf.x60.protocol.InformDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.mytestbed.schema.omf.x60.protocol.InformDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
