/*
 * An XML document type.
 * Localname: itype
 * Namespace: http://schema.mytestbed.net/omf/6.0/protocol
 * Java type: net.mytestbed.schema.omf.x60.protocol.ItypeDocument
 *
 * Automatically generated - do not modify.
 */
package net.mytestbed.schema.omf.x60.protocol;


/**
 * A document containing one itype(@http://schema.mytestbed.net/omf/6.0/protocol) element.
 *
 * This is a complex type.
 */
public interface ItypeDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ItypeDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD09C80FBB114BA180EC1CB4846999213").resolveHandle("itype1fc4doctype");
    
    /**
     * Gets the "itype" element
     */
    net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum getItype();
    
    /**
     * Gets (as xml) the "itype" element
     */
    net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype xgetItype();
    
    /**
     * Sets the "itype" element
     */
    void setItype(net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype.Enum itype);
    
    /**
     * Sets (as xml) the "itype" element
     */
    void xsetItype(net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype itype);
    
    /**
     * An XML itype(@http://schema.mytestbed.net/omf/6.0/protocol).
     *
     * This is an atomic type that is a restriction of net.mytestbed.schema.omf.x60.protocol.ItypeDocument$Itype.
     */
    public interface Itype extends org.apache.xmlbeans.XmlToken
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Itype.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD09C80FBB114BA180EC1CB4846999213").resolveHandle("itypeb195elemtype");
        
        org.apache.xmlbeans.StringEnumAbstractBase enumValue();
        void set(org.apache.xmlbeans.StringEnumAbstractBase e);
        
        static final Enum CREATION_OK = Enum.forString("CREATION.OK");
        static final Enum CREATION_FAILED = Enum.forString("CREATION.FAILED");
        static final Enum STATUS = Enum.forString("STATUS");
        static final Enum RELEASED = Enum.forString("RELEASED");
        static final Enum ERROR = Enum.forString("ERROR");
        static final Enum WARN = Enum.forString("WARN");
        
        static final int INT_CREATION_OK = Enum.INT_CREATION_OK;
        static final int INT_CREATION_FAILED = Enum.INT_CREATION_FAILED;
        static final int INT_STATUS = Enum.INT_STATUS;
        static final int INT_RELEASED = Enum.INT_RELEASED;
        static final int INT_ERROR = Enum.INT_ERROR;
        static final int INT_WARN = Enum.INT_WARN;
        
        /**
         * Enumeration value class for net.mytestbed.schema.omf.x60.protocol.ItypeDocument$Itype.
         * These enum values can be used as follows:
         * <pre>
         * enum.toString(); // returns the string value of the enum
         * enum.intValue(); // returns an int value, useful for switches
         * // e.g., case Enum.INT_CREATION_OK
         * Enum.forString(s); // returns the enum value for a string
         * Enum.forInt(i); // returns the enum value for an int
         * </pre>
         * Enumeration objects are immutable singleton objects that
         * can be compared using == object equality. They have no
         * public constructor. See the constants defined within this
         * class for all the valid values.
         */
        static final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase
        {
            /**
             * Returns the enum value for a string, or null if none.
             */
            public static Enum forString(java.lang.String s)
                { return (Enum)table.forString(s); }
            /**
             * Returns the enum value corresponding to an int, or null if none.
             */
            public static Enum forInt(int i)
                { return (Enum)table.forInt(i); }
            
            private Enum(java.lang.String s, int i)
                { super(s, i); }
            
            static final int INT_CREATION_OK = 1;
            static final int INT_CREATION_FAILED = 2;
            static final int INT_STATUS = 3;
            static final int INT_RELEASED = 4;
            static final int INT_ERROR = 5;
            static final int INT_WARN = 6;
            
            public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
                new org.apache.xmlbeans.StringEnumAbstractBase.Table
            (
                new Enum[]
                {
                    new Enum("CREATION.OK", INT_CREATION_OK),
                    new Enum("CREATION.FAILED", INT_CREATION_FAILED),
                    new Enum("STATUS", INT_STATUS),
                    new Enum("RELEASED", INT_RELEASED),
                    new Enum("ERROR", INT_ERROR),
                    new Enum("WARN", INT_WARN),
                }
            );
            private static final long serialVersionUID = 1L;
            private java.lang.Object readResolve() { return forInt(intValue()); } 
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype newValue(java.lang.Object obj) {
              return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype) type.newValue( obj ); }
            
            public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype newInstance() {
              return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument newInstance() {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.mytestbed.schema.omf.x60.protocol.ItypeDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.mytestbed.schema.omf.x60.protocol.ItypeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
