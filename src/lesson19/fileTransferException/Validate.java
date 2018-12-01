package lesson19.fileTransferException;

import java.util.HashSet;
import java.util.Set;

public class Validate {

    boolean checkMaxSize(Storage storage, File file) throws Exception {
        boolean sizeIsGood;
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
            if (file != null) {
                size = size + file.getSize();
            }
        }
        return size;
    }

    boolean checkFormats(Storage storage, File file) throws Exception {
        for (String format : storage.getFormatsSupported()) {
            if (format != null && format.equals(file.getFormat())) {
                return true;
            }
        }
        throw new Exception("Не удалось добавить файл с id : " + file.getId() + " в хранилеще id : " + storage.getId() + " не подходит формат файла");
    }


    boolean fileIsPresent(Storage storage, File file) throws Exception {
        boolean flag= false;
        for (File checkedFile : storage.getFiles()) {
            if (checkedFile != null && file.getId() == checkedFile.getId()) {
              flag = true;
            }
        }
        return flag;
    }


    File getFileByID(long id, File[] files) {
        for (File founded : files) {
            if (founded != null && founded.getId() == id) {
                return founded;
            }
        }
        return null;
    }

    boolean fileIsPresentByID(Storage storageFrom, long id) {
        boolean isPresent = false;
        for (File checkedFile : storageFrom.getFiles()) {
            if (checkedFile != null && checkedFile.getId() == id)
                isPresent = true;
        }
        return isPresent;
    }

    boolean isValidArgumentsPuttMethod(Storage storage, File file) throws Exception {

        if (file == null)
            throw new Exception("File is null. Not added.");

        if (storage == null)
            throw new Exception("Storage is null. Not added");

        if (fileIsPresent(storage, file))
            throw new Exception("File id " + file.getId() + " is present in Storage id " + storage.getId());

        if (!checkFormats(storage, file))
            throw new Exception("Format file id " + file.getId() + " is not supported by Storage id " + storage.getId());

        if (!checkMaxSize(storage, file))
            throw new Exception("Size of Storage  id :" + storage.getId() + " is not enough to add file  " + file.getId());

        return true;
    }

    boolean isValidArgumentsDellMethod(Storage storage, File file) throws Exception {
        try {
            if (file != null && storage != null &&
                    equalsFileFound(storage, file)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            throw e;
        }
    }

    boolean equalsFileFound(Storage storage, File file) throws Exception {

        for (File checkedFile : storage.getFiles()) {
            if (checkedFile != null && file.equals(checkedFile)) {
                return true;
            }
        }
        throw new Exception("Не удалось удалить  файл с id : " + file.getId() + " с хранилеще id : " + storage.getId() + " не найдено файла");
    }
}
