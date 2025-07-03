package com.ltsllc.commons;

import com.ltsllc.commons.UncheckedLtsllcException;
import org.junit.Test;

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
