package lesson19.fileTransferException;

public class Controller {

    Validate validate = new Validate();

    public File put(Storage storage, File file) throws Exception {
            validate.validateArgumentsPuttMethod(storage, file) ;
            for (int i = 0; i < storage.getFiles().length; i++) {
                if (storage.getFiles()[i] == null) {
                    storage.getFiles()[i] = file;
                    return file;
                }
            }

        return null;
    }

    public File delete(Storage storage, File file) throws Exception {
        validate.validateArgumentsDellMethod(storage, file);
            for (int i = 0; i < storage.getFiles().length; i++) {
                if (storage.getFiles()[i] != null && storage.getFiles()[i].getId() == file.getId()) {
                    storage.getFiles()[i] = null;
                    break;
                }
            }
            return file;
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        for (File fileStorageSource : storageFrom.getFiles()) {
            if (fileStorageSource != null) {
                validate.validateArgumentsDellMethod(storageFrom, fileStorageSource);
                validate.validateArgumentsPuttMethod(storageTo, fileStorageSource);
               // throw new Exception("All files from storage id : " + storageFrom.getId() + " can not transfer to storage is : " + storageTo.getId());
            }
        }

        for (File fileStorageSource : storageFrom.getFiles()) {
       //     long id = fileStorageSource.getId();
            if (fileStorageSource != null) {
                put(storageTo, fileStorageSource);
                delete(storageFrom, fileStorageSource);
            }
        }
    }

    File transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {

        File founded = validate.getFileByID(id, storageFrom.getFiles());
            validate.validateArgumentsDellMethod(storageFrom, founded);
            validate.validateArgumentsPuttMethod(storageTo, founded);
            put(storageTo, founded);
            delete(storageFrom, founded);
            return founded;
    }

}




