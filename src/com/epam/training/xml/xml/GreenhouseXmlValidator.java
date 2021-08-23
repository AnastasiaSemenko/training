package com.epam.training.xml.xml;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class GreenhouseXmlValidator extends DefaultHandler {
    private final StringBuilder error = new StringBuilder();

    private StringBuilder getErrorInfo(SAXParseException e) {
        StringBuilder builder = new StringBuilder();
        builder.append(e.getLineNumber()).append(':').append(e.getColumnNumber());
        builder.append("\n").append(e.getLocalizedMessage());
        return builder;
    }

    public String getError() {
        return error.length() > 0 ? error.toString() : null;
    }

    public boolean validate(String xsdFileName, String xmlFileName) {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = factory.newSchema(new File(xsdFileName));
            Validator validator = schema.newValidator();
            validator.setErrorHandler(this);
            validator.validate(new StreamSource(xmlFileName));
            return getError() == null;
        } catch (IOException e) {
            error.append("Error occurred while reading the file");
            return false;
        } catch (SAXException e) {
            error.append("Error occurred while validating the file");
            return false;
        }
    }

    @Override
    public void warning(SAXParseException e) {
        error.append("WARNING: ");
        error.append(getErrorInfo(e));
    }

    @Override
    public void error(SAXParseException e) {
        error.append("ERROR: ");
        error.append(getErrorInfo(e));
    }

    @Override
    public void fatalError(SAXParseException e) {
        error.append("FATAL ERROR: ");
        error.append(getErrorInfo(e));
    }
}