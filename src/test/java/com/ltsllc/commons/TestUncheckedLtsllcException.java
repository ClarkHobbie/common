package com.ltsllc.commons;

import org.junit.jupiter.api.Test;

public class TestUncheckedLtsllcException {
    @Test
    public void constructor () {
        UncheckedLtsllcException uncheckedLtsllcException = null;

        try {
            throw new UncheckedLtsllcException("hi there");
        } catch (UncheckedLtsllcException e) {
            uncheckedLtsllcException = e;
        }

        assert (uncheckedLtsllcException != null);
    }
}
