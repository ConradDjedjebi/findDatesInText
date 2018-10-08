/**
 * @author Conrad Djedjebi (protected by copyrights)
 * @date 07/10/18
 * @project FiftyFive_Test
 */
package com.conrad.www.tests.InputText;
import com.conrad.www.displayDates.InputText.ReadInput;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReadInputTest {

    @Test
    public void readFileShouldReturnFileContent(){
        ReadInput reader = new ReadInput();
        String file = String.format(System.getProperty("user.dir") + "\\src\\com\\conrad\\www\\tests\\InputText\\test_readInput.txt");
        assertEquals("This text is a test\n", reader.readFile(file), "Text should be \"This text is a test\"");
    }
}
