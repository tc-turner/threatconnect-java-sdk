/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.threatconnect.sdk.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dtineo
 */
public class StringUtil {
    private final static Logger logger = Logger.getLogger(StringUtil.class.getSimpleName());
    private static ObjectMapper mapper = new ObjectMapper();

    public static String formatResults(String data) throws IOException {
        if ( data == null || data.trim().isEmpty() ) {
            throw new IllegalArgumentException("data is null or empty : " + data);
        } 

        if ( data.trim().startsWith("<") ) {
            return formatXML(data);
        } else {
            return formatJSON(data);
        }
        
    }

    public static String toJSON(Object o ) throws JsonProcessingException {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }

    public static String formatJSON(String jsonData) throws JsonProcessingException, IOException {
        Object obj = mapper.readValue(jsonData, Object.class);
        return toJSON(obj);
    }

    public static String formatXML(String xmlData) throws IOException {
        Transformer transformer;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException ex) {
            logger.log(Level.SEVERE, "Error creating Transformer.", ex);
            return xmlData;
        }
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        
        StreamResult result = new StreamResult(new StringWriter());
        StreamSource source = new StreamSource(new StringReader(xmlData));
        try {
            transformer.transform(source, result);
        } catch (TransformerException ex) {
            logger.log(Level.SEVERE, "Error transforing xml: " + xmlData, ex);
            return xmlData;
        }
        String formatted = result.getWriter().toString();

        return formatted;
    }

}
