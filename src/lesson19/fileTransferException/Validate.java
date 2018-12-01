package lesson19.fileTransferException;

public class Validate {

    boolean checkMaxSize(Storage storage, File file) throws Exception {

        if (storage.getStorageSize() > getCurrentSizeOfStorage(storage) + file.getSize()) {
            return true;
        } else {
            return false;
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

    boolean checkFormats(Storage storage, File file) throws Exception {
        boolean flag = false;
        for (String format : storage.getFormatsSupported()) {
            if (format != null && format.equals(file.getFormat())) {
                flag = true;
            }
        }
        return flag;
    }


    boolean fileIsPresent(Storage storage, File file) throws Exception {
        boolean flag = false;
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

        if (file == null)
            throw new Exception("File is null. Not deleted.");
        if (storage == null)
            throw new Exception("Storage is null. Not deleted.");
        if (!equalsFileFound(storage, file))
            throw new Exception("File not found. File id : " + file.getId() + " file name : " + file.getName());

        return true;
    }


    boolean equalsFileFound(Storage storage, File file) throws Exception {
        boolean flag = false;
        for (File checkedFile : storage.getFiles()) {
            if (checkedFile != null && file.equals(checkedFile)) {
                flag = true;
            }
        }
        return flag;
    }
}
