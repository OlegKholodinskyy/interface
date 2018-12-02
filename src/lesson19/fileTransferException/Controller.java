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
        if ( validate.isValidArgumentsDellMethod(storage, file)) {
            for (int i = 0; i < storage.getFiles().length; i++) {
                if (storage.getFiles()[i].getId()==file.getId()) {
                    storage.getFiles()[i] = null;
                    break;
                }
            } return file;
        }
        return null;
    }

    public void transferAll(Storage storageFrom, Storage storageTo) {
        for (File fileStorageSource : storageFrom.getFiles()) {
            try {
                transferFile(storageFrom, storageTo, fileStorageSource.getId());
            } catch (Exception e) {
                System.out.println("File id : " + fileStorageSource.getId() + " not transfered to Storage id : " + storageTo.getId());
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


    private File[] deleteFileFromArray(Storage storage, File file) throws Exception {

        File[] newArrayFiles = new File[storage.getFiles().length - 1];
        int countMatches = 0;
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i].equals(file))
                countMatches++;
        }

        if (countMatches != 0) {
            int tmp = 0;
            for (int i = 0; i < storage.getFiles().length; i++) {
                if (!storage.getFiles()[i].equals(file)) {
                    newArrayFiles[tmp] = storage.getFiles()[i];
                    tmp++;
                } else {
                    continue;
                }
            }
            return newArrayFiles;
        } else {
            return storage.getFiles();
        }
    }
}




