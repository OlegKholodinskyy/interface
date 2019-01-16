package lesson28.example2;

import java.util.Comparator;

public class DateComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        if (o2.getDateCreated() != null && o1.getDateCreated() != null) {
            return (o2.getDateCreated().compareTo(o1.getDateCreated()));
        }
        return 0;
    }
}
