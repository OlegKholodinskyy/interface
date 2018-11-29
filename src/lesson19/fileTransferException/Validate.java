package lesson19.fileTransferException;

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
            size = size + file.getSize();
        }
        return size;
    }

    boolean checkFormats(Storage storage, File file) throws Exception {
        boolean formatIsInOrder = false;

        for (String format : storage.getFormatsSupported()) {
            if (format.equals(file.getFormat())) {
                formatIsInOrder = true;
            }
        }
        if (formatIsInOrder == true) {
            return formatIsInOrder;
        } else {
            throw new Exception("Не удалось добавить файл с id : " + file.getId() + " в хранилеще id : " + storage.getId() + " не подходит формат файла");
        }
    }

    boolean fileIsPresent(Storage storage, File file) throws Exception {
        boolean isPresent = false;
        for (File checkedFile : storage.getFiles()) {
            if (file.getId() == checkedFile.getId()) {
                isPresent = true;
            }
        }
        if (isPresent == true) {
            throw new Exception("Не удалось добавить файл с id : " + file.getId() + " в хранилеще id : " + storage.getId() + " файл с таким ІД уже существует");
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


    boolean chechName(File file) throws Exception {
        if (file.getName().length() > 10) {
            throw new Exception("Название файла превышает допустимую длинну . id: " + file.getId());
        }
        return true;
    }

    boolean isValidArgumentsPuttMethod(Storage storage, File file) throws Exception {
        try {
            if (file != null && storage != null &&
                    chechName(file) &&
                    !fileIsPresent(storage, file) &&
                    checkFormats(storage, file) &&
                    checkMaxSize(storage, file)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            throw e;
        }
    }

    boolean isValidArgumentsDellMethod(Storage storage, File file) throws Exception {
        try {
            if (file != null && storage != null &&
                    equalsFileFound(storage, file) ) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            throw e;
        }
    }
    boolean equalsFileFound(Storage storage, File file) throws Exception {
        boolean isPresent = false;
        for (File checkedFile : storage.getFiles()) {
            if (file.equals(checkedFile)) {
                isPresent = true;
            }
        }
        if (isPresent == false) {
            throw new Exception("Не удалось удалить  файл с id : " + file.getId() + " с хранилеще id : " + storage.getId() + " не найдено файла");
        } else {
            return isPresent;
        }
    }
}