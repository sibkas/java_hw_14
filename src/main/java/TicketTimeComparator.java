import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        // ваш код
        if (t1.getFlightTime() < t2.getFlightTime()) {
            return -1;
        } else if (t1.getFlightTime() > t2.getFlightTime()) {
            return 1;
        } else {
            return 0;
        }
    }
}