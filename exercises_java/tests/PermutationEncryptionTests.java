import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermutationEncryptionTests {

    @Test
    public void test1(){
        String message = "Four score and seven years ago";
        int [] key = { 1 };
        String encryptedMessage = PermutationEncryption.permutationEncryption(key, message);
        assertEquals(message, encryptedMessage);
    }

    @Test
    public void test2(){
        String message = "that all men are created equal.";
        int [] key = {5, 10, 8, 1, 3, 6, 4, 7, 2, 9};
        String expected = " mltaatlh rece ea nr luaeedqta   .      ";
        String encrypted = PermutationEncryption.permutationEncryption(key, message);
        assertEquals(expected, encrypted);
    }
}
