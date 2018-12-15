package lesson25.homework;

import lesson25.homework.exception.BadRequestException;
import lesson25.homework.exception.InternalServerException;

public class GeneralDAO<T> {
    private T[] arrayT = (T[]) new Object[5];


    public T save(T t) throws BadRequestException, InternalServerException {
        validate(t);
        for (int j = 0; j < arrayT.length; j++) {
            if (arrayT[j] == null) {
                arrayT[j] = (T) t;
                System.out.println("Object + " + t.getClass().toString() + " is added");
                return arrayT[j];
            }
        }
        throw new InternalServerException("Can not save element. Server error");
    }

    private void validate(T t) throws BadRequestException {
        if (t == null)
            throw new BadRequestException("Can not save null object");
        for (int j = 0; j < arrayT.length; j++) {
            if (arrayT[j] != null && arrayT[j].equals(t)) {
                throw new BadRequestException("Can not save. Object is already present.");
            }
        }
    }

    public T[] getAll() {
        int z = 0;
        for (int i = 0; i < arrayT.length; i++) {
            if (arrayT[i] == null) {
                z = i;
                break;
            }
        }
        T[] arrayNotNullElements = (T[]) new Object[z];

        int index = 0;
        for (int i = 0; i < z; i++) {
            arrayNotNullElements[index] = arrayT[i];
            System.out.println(arrayNotNullElements[index]);
        }
        return arrayNotNullElements;
    }
}
