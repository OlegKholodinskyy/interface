package lesson19.fileTransferException;

public class Validate {

    void validateArgumentsPuttMethod(Storage storage, File file) throws Exception {
        fileIsPresent(storage, file);
        checkFormats(storage, file);
        checkMaxSize(storage, file);
    }

    void validateArgumentsDellMethod(Storage storage, File file) throws Exception {
        equalsFileFound(storage, file);
        }

    void checkMaxSize(Storage storage, File file) throws Exception {

        if (storage.getStorageSize() <= getCurrentSizeOfStorage(storage) + file.getSize()) {
            throw new Exception("Size of Storage  id :" + storage.getId() + " is not enough to add file  " + file.getId());
        }
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

    void checkFormats(Storage storage, File file) throws Exception {

        for (String format : storage.getFormatsSupported()) {
            if (format != null && format.equals(file.getFormat())) {
                return;
            }
        }
        throw new Exception("Format file id " + file.getId() + " is not supported by Storage id " + storage.getId());
    }


    void fileIsPresent(Storage storage, File file) throws Exception {

        for (File checkedFile : storage.getFiles()) {
            if (checkedFile != null && file.getId() == checkedFile.getId()) {
                throw new Exception("File id " + file.getId() + " is present in Storage id " + storage.getId());
            }
        }
    }


    File getFileByID(long id, File[] files) {
        for (File founded : files) {
            if (founded != null && founded.getId() == id) {
                return founded;
            }
        }
        return null;
    }

    void equalsFileFound(Storage storage, File file) throws Exception {

        for (File checkedFile : storage.getFiles()) {
            if (checkedFile != null && file.getId() == checkedFile.getId()) {
                return;
            }
        }
        throw new Exception("File not found. File id : " + file.getId() + " file name : " + file.getName());
    }
}
