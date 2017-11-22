import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecryptMessagesTests {

    @Test
    public void decryptMessagesTest1(){
        String message = "a";
        String expected = "z";
        assertEquals(expected, DecryptMessages.answer(message));
    }

    @Test
    public void rest2(){
        //
        String message = "y b";
        String expected = "b y";
        assertEquals(expected, DecryptMessages.answer(message));
    }
}
