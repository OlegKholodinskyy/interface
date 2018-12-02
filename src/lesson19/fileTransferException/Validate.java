package lesson19.fileTransferException;

public class Validate {

    boolean checkMaxSize(Storage storage, File file) throws Exception {

        if (storage.getStorageSize() > getCurrentSizeOfStorage(storage) + file.getSize()) {
            return true;
        }
        throw new Exception("Size of Storage  id :" + storage.getId() + " is not enough to add file  " + file.getId());

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
        throw new Exception("Format file id " + file.getId() + " is not supported by Storage id " + storage.getId());
    }


    boolean fileIsPresent(Storage storage, File file) throws Exception {

        for (File checkedFile : storage.getFiles()) {
            if (checkedFile != null && file.getId() == checkedFile.getId()) {
                throw new Exception("File id " + file.getId() + " is present in Storage id " + storage.getId());
            }
        }
        return true;
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

        checkNotNullFile(file);
        checkNotNullStorage(storage);
        fileIsPresent(storage, file);
        checkFormats(storage, file);
        checkMaxSize(storage, file);

        return true;
    }

    private void checkNotNullFile(File file) throws Exception {
        if (file == null)
            throw new Exception("File is null. Not added.");
    }

    private void checkNotNullStorage(Storage storage) throws Exception {
        if (storage == null)
            throw new Exception("Storage is null. Not added");
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
