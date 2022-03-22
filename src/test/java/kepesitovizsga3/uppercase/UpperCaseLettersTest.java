package kepesitovizsga3.uppercase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

public class UpperCaseLettersTest {

    @Test
    public void testGetNumberOfUpperCase() {
        Assertions.assertEquals(8, new UpperCaseLetters().getNumberOfUpperCase(Path.of("src/test/resources/characters.txt")));
    }
}