package lesson19.fileTransferException;

public class Validate {

    boolean checkMaxSize(Storage storage, File file) throws Exception {
    boolean sizeIsGood = false;
    if (storage.getStorageSize() > getCurrentSizeOfStorage(storage) + file.getSize()) {
        sizeIsGood = true;
    } else {
        throw new Exception("Не удалось добавить файл с id : " + file.getId() + " в хранилеще id : " + storage.getId() + " превышен размер хранилища");
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
     boolean checkFormats(Storage storage, File file) throws Exception {
        boolean formatIsInOrder ;
        if (!storage.getFormatsSupported().equals(file.getFormat())) {
            formatIsInOrder = true;
        } else {
            throw new Exception("Не удалось добавить файл с id : " + file.getId() + " в хранилеще id : " + storage.getId() + "не подходит формат файла");
        }
        return formatIsInOrder;
    }

     boolean fileIsPresent(Storage storage, File file) {
        boolean isPresent = false;
        for (File checkedFile : storage.getFiles()) {
            if (file.equals(checkedFile))
                isPresent = true;
        }
        return isPresent;
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
}
