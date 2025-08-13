import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AviaSoulsTest {

    @Test
    public void testCompareToByPriceAndFlightTime() {
        Ticket t1 = new Ticket("MOW", "LED", 1500, 10, 13); // flightTime = 3
        Ticket t2 = new Ticket("MOW", "LED", 1500, 11, 12); // flightTime = 1
        Ticket t3 = new Ticket("MOW", "LED", 1200, 9, 13);  // flightTime = 4

        // Сравнение по цене
        assertTrue(t3.compareTo(t1) < 0); // t3 дешевле t1
        assertTrue(t1.compareTo(t3) > 0); // t1 дороже t3

        // Цены равны, сравнение по времени полёта
        assertTrue(t2.compareTo(t1) < 0); // t2 flightTime меньше t1
        assertTrue(t1.compareTo(t2) > 0); // t2 flightTime больше t1
        assertEquals(0, t1.compareTo(new Ticket("MOW", "LED", 1500, 10, 13))); // равные билеты
    }

    @Test
    public void testSearchSortsByPriceAndFlightTime() {
        AviaSouls manager = new AviaSouls();

        Ticket t1 = new Ticket("MOW", "LED", 1700, 10, 13); // flightTime = 3
        Ticket t2 = new Ticket("MOW", "LED", 1500, 11, 12); // flightTime = 1
        Ticket t3 = new Ticket("MOW", "LED", 1200, 9, 13);  // flightTime = 4

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);

        Ticket[] expected = {t3, t2, t1};
        Ticket[] actual = manager.search("MOW", "LED");

        assertArrayEquals(expected, actual, "Массив должен быть отсортирован по цене по возрастанию");
    }

    @Test
    public void testTicketTimeComparator() {
        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket t1 = new Ticket("MOW", "LED", 1000, 10, 15); // flightTime = 5
        Ticket t2 = new Ticket("MOW", "LED", 1000, 11, 12); // flightTime = 1
        Ticket t3 = new Ticket("MOW", "LED", 1000, 9, 14);  // flightTime = 5

        assertTrue(comparator.compare(t2, t1) < 0);// t2 должен быть меньше t1 по времени полёта
        assertTrue(comparator.compare(t1, t2) > 0);// t1 должен быть больше t2 по времени полёта
        assertEquals(0, comparator.compare(t1, t3));// t1 и t3 имеют одинаковое время полёта
    }


    @Test
    public void testSearchAndSortByFlightTime() {
        AviaSouls manager = new AviaSouls();

        Ticket t1 = new Ticket("MOW", "LED", 1500, 10, 15); // flightTime = 5
        Ticket t2 = new Ticket("MOW", "LED", 1200, 9, 11);  // flightTime = 2
        Ticket t3 = new Ticket("MOW", "LED", 1300, 8, 12);  // flightTime = 4

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {t2, t3, t1}; // по возрастанию времени полёта
        Ticket[] actual = manager.search("MOW", "LED");

        assertArrayEquals(expected, actual);// Массив должен быть отсортирован по времени полёта
    }


}