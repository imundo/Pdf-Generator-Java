package com.request;

import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.copy.HierarchicalStreamCopier;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;


import java.io.*;

import com.thoughtworks.xstream.XStream;


public final class GeneradorXML {
    private XStream xstream = null;
    public GeneradorXML(){
        xstream = new XStream();
        xstream.ignoreUnknownElements();
    }
    /**
     * Convert a any given Object to a XML String
     * @param object
     * @return
     */
    public String toXMLString(EnrollmentTransactions enrollmentTransactions) {
        return xstream.toXML(enrollmentTransactions);
    }
    /**
     * Convert given XML to an Object
     * @param xml
     * @return
     */
    public Object toObject(String xml) {
        return (Object) xstream.fromXML(xml);
    }
    /**
     * return this class instance
     * @return
     */
    public static GeneradorXML getInstance(){
        return new GeneradorXML();
    }
    /**
     * convert to Object from given File
     * @param xmlFile
     * @return
     * @throws IOException
     */
    public Object toObject(File xmlFile) throws IOException {
        return xstream.fromXML(new FileReader(xmlFile));
    }
    /**
     * create XML file from the given object, file name is generated automatically (class name)
     * @param objTobeXMLTranslated
     * @throws IOException
     * @throws XStreamTranslateException
     */
    public byte[] toXMLFile(EnrollWorkflowDetailResponse list) throws IOException {
        XStream xstream = new XStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {

            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
            xstream.toXML(list, writer);
            String xml = outputStream.toString("UTF-8");

//            xstream.marshal(enrollmentTransactions, xmlWriter);
//            return  baos.toByteArray();


//            HierarchicalStreamCopier copier = new HierarchicalStreramCopier();
//            HierarchicalStreamDriver binaryDriver = new BinaryDriver();
//            HierarchicalStreamDriver jsonDriver = new JettisonMappedXmlDriver();
//
//// transform a org.dom4j.Document into a binary stream of XStream
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            copier.copy(Dom4JDriver.createReader(enrollmentTransactions), binaryDriver.createWriter(baos));
//            byte[] data = baos.toByteArray();
//
//// transform binary XStream data into JSON
//            StringWriter strWriter = new StringWriter();
//            copier.copy(binaryDriver.createReader(data), jsonDriver.createWriter(strWriter));
//            String json = strWriter.toString();
//
//// transform JSON into XML:
//            strWriter = new StringWriter();
//            copier.copy(jsonDriver.createReader(new StringReader(json)), new PrettyPrintWriter(strWriter));
//            String xml = strWriter.toString();
//            String xml = xstream.toXML(enrollmentTransactions);
        }catch(Exception e) {

        }
        return outputStream.toByteArray();
    }
}


