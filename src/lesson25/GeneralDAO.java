package lesson25;

import lesson25.exception.BadRequestException;
import lesson25.exception.InternalServerException;
import lesson25.exception.LimitExceeded;

public class GeneralDAO<T> {
    private  T[] arrayT = (T[])new Object[5];


    public <T extends HelperId> T save(T t) throws BadRequestException, InternalServerException {
        validate(t);
        for (int j =0; j<arrayT.length; j++){
            if(arrayT[j]==null){
                arrayT[j] = (T) t;
                return arrayT[j];
            }
        }
        throw new InternalServerException("Can not save element id: " + t.getId() + " Server error");
    }

    private <T extends HelperId> void validate(T t) throws BadRequestException {
        if (t == null)
            throw new BadRequestException("Can not save null object");
        for (int j=0; j<arrayT.length; j++) {
            if (arrayT[j]!=null && arrayT[j].equals(t)) {
                throw new BadRequestException("Can not save. Object is already present. id: " + t.getId());
            }
        }
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
