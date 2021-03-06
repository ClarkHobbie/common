package com.ltsllc.common.util;

import org.junit.Test;


import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Clark on 6/28/2017.
 */
class UtilsTest {
    @Test
    public void testWhatever () throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        Utils.writeAsPem("whatever", publicKey);
    }
}