package com.example.Webtech_Projekt;

import com.example.service.AES;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class WebtechProjektCryptionTest {

    @Test
    @DisplayName("should display correct string after encrypting and decrypting")
    void testCryption() {
        String originalString = "howtodoinjava.com";
        String encryptedString = AES.encrypt(originalString) ;
        String decryptedString = AES.decrypt(encryptedString) ;

        System.out.println(AES.secret);
        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
        assertEquals(originalString, decryptedString);
    }
}
