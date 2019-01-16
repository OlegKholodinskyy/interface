package lesson28.example2;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        // якщо сhanelName не ріне то порівнюємо по ньому в першу чергу
        // якщо рівне - то переходимо до порівняння по fingerprint
        // якщо fingerprint не рівне - то порівнюю по ньому
        //  якщо рівне - то порівнюю по dateCreated
        // якщо і це поле рівне - то  обєкти рівні
     if (o1.getChannelName() != null && o2.getChannelName() != null && !o1.getChannelName().equals(o2.getChannelName()))
                return o1.getChannelName().compareTo(o2.getChannelName());

     if (o1.getFingerprint()!=null && o2.getFingerprint()!=null && !o1.getFingerprint().equals(o2.getFingerprint()))
            return o1.getFingerprint().compareTo(o2.getFingerprint());

     if (o1.getDateCreated()!=null && o2.getDateCreated()!= null && !o1.getDateCreated().equals(o2.getDateCreated()))
            return (o2.getDateCreated().compareTo(o1.getDateCreated()));
        return 0;
    }
}