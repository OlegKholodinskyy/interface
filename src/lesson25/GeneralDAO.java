package lesson25;

import lesson25.exception.BadRequestException;
import lesson25.exception.LimitExceeded;

import java.lang.reflect.Array;
import java.lang.reflect.Type;

public class GeneralDAO<T extends HelperId> {
    int j = 0;
    T[] arrayT;

    public GeneralDAO(Class<T> tclass) {
        arrayT = (T[]) Array.newInstance(tclass, 10);
    }

    public static <T extends HelperId> GeneralDAO<T> create(Class<T> tclass) {
        return new GeneralDAO<T>(tclass);
    }

    public T save(T t) throws BadRequestException {
        validate(t);
        arrayT[j] = t;
        return arrayT[j];
    }

    private void validate(T t) throws BadRequestException {
        if (t == null)
            throw new BadRequestException("Can not save null object");
        for (T element : arrayT) {
            if (element!=null && element.equals(t)) {
                throw new BadRequestException("Can not save. Object is already present. id: " + t.getId());
            }
        }
        checkFreeSpace(t);
    }

    private void checkFreeSpace(T t) throws LimitExceeded {
        for (int i = 0; i < arrayT.length; i++) {
            if (arrayT[i] == null) {
                break;
            }

            throw new LimitExceeded("Can not save . id: " + t.getId() + " Not enough free space");
        }
    }
    public T[] getAll() {
        return arrayT;
    }

}
