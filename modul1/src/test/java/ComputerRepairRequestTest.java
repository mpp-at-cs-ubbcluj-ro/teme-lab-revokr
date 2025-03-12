import model.ComputerRepairRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ComputerRepairRequestTest {
    @Test
    @DisplayName("1st test")
    void test1() {
        ComputerRepairRequest crr = new ComputerRepairRequest(1, "Gheorghe", "14 Decembrie nr 2", "0756533897", "X7000", "24/03/2025", "Microsoft Word crashes video card.");
        assertEquals(crr.getOwnerName(), "Gheorghe");
        assertEquals(crr.getID(), 1);
    }

    @Test
    @DisplayName("2nd test")
    void test2() {
        assertEquals(2, 2);
    }
}
