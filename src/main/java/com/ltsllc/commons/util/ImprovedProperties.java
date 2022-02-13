package com.ltsllc.commons.util;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * An improved version of the Properties class
 *
 * This class improves on its ancestor by offering
 * <UL>
 * <LI>getting an INTEGER property</LI>
 * <LI>setting properties if they are null</LI>
 * </UL>
 */
public class ImprovedProperties extends Properties {
    public static final Logger logger = LogManager.getLogger();

    /*
     * create an empty properties
     */
    public ImprovedProperties () {
        super();
    }

    /*
     * get an integer property
     *
     * This method translates a String property to an integer property.  In the case where the named property
     * is null, the method returns 0.
     */
    public int getIntProperty (String name) {
        logger.debug("entering getIntProperty with name = " + name);
        String value = getProperty(name);

        if (null == value) {
            value = "0";
        }
        
        logger.debug("leaving getIntProperty with value = " + value);
        return Integer.parseInt(value);
    }

    /*
     * get an integer property, with a default value.
     *
     * If the named property is null, then the method returns the default value.
     */
    public int getIntProperty(String name, String defaultValue) {
        String propertyValue = getProperty(name);
        if (null == propertyValue) {
            propertyValue = defaultValue;
        }

        return Integer.parseInt(propertyValue);
    }

    /*
     * set a bunch of properties if they are undefined (null)
     *
     * This method sets properties if they are null.
     *
     * @param properties The properties to define if they are currently null
     */
    public void setIfNull (Properties properties){
        logger.debug("entering setIfNull with properties = " + properties);
        for (Object keyObject : properties.keySet()) {
            String key = keyObject.toString();
            String value = getProperty(key);

            if (null == value) {
                value = properties.getProperty(key);
            }

            setProperty(key, value);
        }
        logger.debug("leaving setIfNull with properties = " + this);
    }

    /*
     * set a property if it is currently null
     *
     * This method set a property only if it is currently null, otherwise, it does nothing
     */
    public void setIfNull (String key, String value) {
        logger.debug("entering setIfNull with key = " + key + " and value = " + value);
        if (getProperty(key) == null) {
            setProperty(key, value);
        }
        logger.debug("leaving setIfNull with properties = " + this);
    }
}
