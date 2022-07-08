package algo.util;

import algo.util.Numbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumbersTest {

    @Test
    void shouldConvertToBinary() {
        final long givenNumber = 10;
        final long givenRadix = 2;

        final String expected = "1010";
        final String actual = Numbers.convert(givenNumber, givenRadix);

        assertEquals(expected, actual);
    }

    @Test
    void dostuff(){
        final String a = Numbers.convert(1010, 10);
        System.out.println(a);
    }
}
