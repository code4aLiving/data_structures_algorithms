import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecretMessageTest {

    @Test
    public void test1(){
        String emessage = SecretMessage.secretMessage("iloveyouJack");
        assertEquals("Jeiaylcookuv", emessage);
    }
}
