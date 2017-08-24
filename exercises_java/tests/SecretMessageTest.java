import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SecretMessageTest {

    @Test
    public void test1(){
        String emessage = SecretMessage.secretMessage("iloveyouJack");
        assertEquals("Jeiaylcookuv", emessage);
    }
}
