package com.ltsllc.commons.util;

import org.junit.jupiter.api.Test;

class ImprovedPropertiesTest {

    @Test
    void getBooleanProperty() {
        boolean value = true;

        ImprovedProperties improvedProperties = new ImprovedProperties();
        improvedProperties.setBooleanProperty("whatever", value);
        value = improvedProperties.getBooleanProperty("whatever");

        assert (value == true);

        value = improvedProperties.getBooleanProperty("idontexist");

        assert (value == false);
    }

    @Test
    void setBooleanProperty() {
        ImprovedProperties improvedProperties = new ImprovedProperties();

        boolean value = improvedProperties.getBooleanProperty("whatever");

        assert (value ==  false);

        improvedProperties.setBooleanProperty("whatever", true);

        value = improvedProperties.getBooleanProperty("whatever");

        assert (value == true);
    }
}