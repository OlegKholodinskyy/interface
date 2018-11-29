package lesson19.fileTransferException;

public class Validate {

    boolean checkMaxSize(Storage storage, File file) throws IllegalArgumentException {
        boolean sizeIsGood;
        if (storage.getStorageSize() > getCurrentSizeOfStorage(storage) + file.getSize()) {
            sizeIsGood = true;
        } else {
            throw new IllegalArgumentException("Не удалось добавить файл с id : " + file.getId() + " в хранилеще id : " + storage.getId() + " превышен размер хранилища");
        }
        return sizeIsGood;
    }

    long getCurrentSizeOfStorage(Storage storage) {
        long size = 0;
        for (File file : storage.getFiles()) {
            size = size + file.getSize();
        }
        return size;
    }

    boolean checkFormats(Storage storage, File file) throws IllegalArgumentException {
        boolean formatIsInOrder = false;

        for (String format : storage.getFormatsSupported()) {
            if (format.equals(file.getFormat())) {
                formatIsInOrder = true;
            }
        }
        if (formatIsInOrder == true) {
            return formatIsInOrder;
        } else {
            throw new IllegalArgumentException("Не удалось добавить файл с id : " + file.getId() + " в хранилеще id : " + storage.getId() + " не подходит формат файла");
        }
    }

    boolean fileIsPresent(Storage storage, File file) throws IllegalArgumentException {
        boolean isPresent = false;
        for (File checkedFile : storage.getFiles()) {
            if (file.equals(checkedFile))
                isPresent = true;
        }
        if (isPresent == true) {
            throw new IllegalArgumentException("Не удалось добавить файл с id : " + file.getId() + " в хранилеще id : " + storage.getId() + " файл с таким ІД уже существует");
        } else {
            return isPresent;
        }
    }

    File getFileByID(long id, File[] files) {
        for (File founded : files) {
            if (founded.getId() == id) {
                return founded;
            }
        }
        return null;
    }

    boolean fileIsPresentByID(Storage storageFrom, long id) {
        boolean isPresent = false;
        for (File checkedFile : storageFrom.getFiles()) {
            if (checkedFile.getId() == id)
                isPresent = true;
        }
        return isPresent;
    }



    boolean chechName(File file) throws IllegalArgumentException {
        if (file.getName().length()> 10){
            throw new IllegalArgumentException("Название файла превышает допустимую длинну . id: " + file.getId());
        }
        return true;
    }

    boolean isValidArgumentsPuttMethod(Storage storage, File file){
       if (     !file.equals(null) && !storage.equals(null) &&
                chechName(file) &&
                !fileIsPresent(storage, file) &&
                checkFormats(storage, file) &&
                checkMaxSize(storage, file)){
           return true;
       }
       else{
           return false;
       }
    }

}
