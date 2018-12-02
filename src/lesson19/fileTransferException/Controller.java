package lesson19.fileTransferException;

public class Controller {

    Validate validate = new Validate();

    public File put(Storage storage, File file) throws Exception {
        if (validate.isValidArgumentsPuttMethod(storage, file)) {
            for (int i = 0; i < storage.getFiles().length; i++) {
                if (storage.getFiles()[i] == null) {
                    storage.getFiles()[i] = file;
                    break;
                }
            }
            return file;
        }
        return null;
    }

    public File delete(Storage storage, File file) throws Exception {
        if (validate.isValidArgumentsDellMethod(storage, file)) {
            for (int i = 0; i < storage.getFiles().length; i++) {
                if (storage.getFiles()[i].getId() == file.getId()) {
                    storage.getFiles()[i] = null;
                    break;
                }
            }
            return file;
        }
        return null;
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        for (File fileStorageSource : storageFrom.getFiles()) {
            if (fileStorageSource != null) {
                if (!validate.isValidArgumentsDellMethod(storageFrom, fileStorageSource) || !validate.isValidArgumentsPuttMethod(storageTo, fileStorageSource)) {
                    throw new Exception("All files from storage id : " + storageFrom.getId() + " can not transfer to storage is : " + storageTo.getId());
                }
            }
        }

        for (File fileStorageSource : storageFrom.getFiles()) {
            if (fileStorageSource != null) {
                put(storageTo, fileStorageSource);
                delete(storageFrom, fileStorageSource);
            }
        }
    }

    File transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {

        File founded = validate.getFileByID(id, storageFrom.getFiles());
        if (validate.isValidArgumentsDellMethod(storageFrom, founded) && validate.isValidArgumentsPuttMethod(storageTo, founded)) {
            put(storageTo, founded);
            delete(storageFrom, founded);
            return founded;
        }
        return null;
    }
    
}




