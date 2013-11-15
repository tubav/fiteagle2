/*
 * An XML document type.
 * Localname: release
 * Namespace: http://schema.mytestbed.net/omf/6.0/protocol
 * Java type: net.mytestbed.schema.omf.x60.protocol.ReleaseDocument
 *
 * Automatically generated - do not modify.
 */
package net.mytestbed.schema.omf.x60.protocol;


/**
 * A document containing one release(@http://schema.mytestbed.net/omf/6.0/protocol) element.
 *
 * This is a complex type.
 */
public interface ReleaseDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ReleaseDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD09C80FBB114BA180EC1CB4846999213").resolveHandle("releasea320doctype");
    
    /**
     * Gets the "release" element
     */
    net.mytestbed.schema.omf.x60.protocol.ReleaseDocument.Release getRelease();
    
    /**
     * Sets the "release" element
     */
    void setRelease(net.mytestbed.schema.omf.x60.protocol.ReleaseDocument.Release release);
    
    /**
     * Appends and returns a new empty "release" element
     */
    net.mytestbed.schema.omf.x60.protocol.ReleaseDocument.Release addNewRelease();
    
    /**
     * An XML release(@http://schema.mytestbed.net/omf/6.0/protocol).
     *
     * This is a complex type.
     */
    public interface Release extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Release.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD09C80FBB114BA180EC1CB4846999213").resolveHandle("release994delemtype");
        
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
         * Gets array of all "res_id" elements
         */
        java.lang.String[] getResIdArray();
        
        /**
         * Gets ith "res_id" element
         */
        java.lang.String getResIdArray(int i);
        
        /**
         * Gets (as xml) array of all "res_id" elements
         */
        org.apache.xmlbeans.XmlString[] xgetResIdArray();
        
        /**
         * Gets (as xml) ith "res_id" element
         */
        org.apache.xmlbeans.XmlString xgetResIdArray(int i);
        
        /**
         * Returns number of "res_id" element
         */
        int sizeOfResIdArray();
        
        /**
         * Sets array of all "res_id" element
         */
        void setResIdArray(java.lang.String[] resIdArray);
        
        /**
         * Sets ith "res_id" element
         */
        void setResIdArray(int i, java.lang.String resId);
        
        /**
         * Sets (as xml) array of all "res_id" element
         */
        void xsetResIdArray(org.apache.xmlbeans.XmlString[] resIdArray);
        
        /**
         * Sets (as xml) ith "res_id" element
         */
        void xsetResIdArray(int i, org.apache.xmlbeans.XmlString resId);
        
        /**
         * Inserts the value as the ith "res_id" element
         */
        void insertResId(int i, java.lang.String resId);
        
        /**
         * Appends the value as the last "res_id" element
         */
        void addResId(java.lang.String resId);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "res_id" element
         */
        org.apache.xmlbeans.XmlString insertNewResId(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "res_id" element
         */
        org.apache.xmlbeans.XmlString addNewResId();
        
        /**
         * Removes the ith "res_id" element
         */
        void removeResId(int i);
        
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
            public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument.Release newInstance() {
              return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument.Release) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument.Release newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument.Release) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument newInstance() {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.mytestbed.schema.omf.x60.protocol.ReleaseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.mytestbed.schema.omf.x60.protocol.ReleaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
