/*
 * An XML document type.
 * Localname: props
 * Namespace: http://schema.mytestbed.net/omf/6.0/protocol
 * Java type: net.mytestbed.schema.omf.x60.protocol.PropsDocument
 *
 * Automatically generated - do not modify.
 */
package net.mytestbed.schema.omf.x60.protocol;


/**
 * A document containing one props(@http://schema.mytestbed.net/omf/6.0/protocol) element.
 *
 * This is a complex type.
 */
public interface PropsDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(PropsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD09C80FBB114BA180EC1CB4846999213").resolveHandle("propse297doctype");
    
    /**
     * Gets the "props" element
     */
    net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props getProps();
    
    /**
     * Sets the "props" element
     */
    void setProps(net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props props);
    
    /**
     * Appends and returns a new empty "props" element
     */
    net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props addNewProps();
    
    /**
     * An XML props(@http://schema.mytestbed.net/omf/6.0/protocol).
     *
     * This is a complex type.
     */
    public interface Props extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Props.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD09C80FBB114BA180EC1CB4846999213").resolveHandle("propsb43belemtype");
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props newInstance() {
              return (net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument newInstance() {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.mytestbed.schema.omf.x60.protocol.PropsDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.mytestbed.schema.omf.x60.protocol.PropsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
