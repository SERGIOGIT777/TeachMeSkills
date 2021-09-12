import DZ6.ZD1;
import DZ6.ZD2;
import DZ6.ZD3;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestDZ6 {
    @Test
    public void testProcessing() {
        var test = ZD2.rename("OOOHjhjHHJJHD");
        assertEquals(test, "OOOOjhjOOJJOD");
    }

    @Test
    public void testZD1() {
        var test = ZD1.trim("fmsknfaaaabajsbaabbabab");
        assertEquals(test, "aaaabajsbaabbaba");
    }

    @Test
    public void testDZ3() {
        var test = ZD3.trimInsert(new String[]{"vfvf", "vffv", "reet", "reer"});
        assertEquals(test, Arrays.toString(new String[]{"null", "vffv", "null", "reer"}));
    }

    @Test
    public void testDZ3_1(){
        var test = ZD3.trimInsert2(new String[]{"vfvf", "vffv", "reet", "reer"});
        assertEquals(test, Arrays.toString(new String[]{"vffv", "reer"}));
    }
}
