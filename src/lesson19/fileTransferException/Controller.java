package lesson19.fileTransferException;

public class Controller {

    Validate validate = new Validate();

    public File put(Storage storage, File file) throws Exception {
        if (validate.isValidArgumentsPuttMethod(storage, file)) {
            storage.setFiles(addFileToArray(storage, file));
            return file;
        }
            return null;
    }

    public File delete(Storage storage, File file) throws Exception {
        if (validate.isValidArgumentsDellMethod(storage, file)) {
            storage.setFiles(deleteFileFromArray(storage, file));
            return file;
        } else
            return null;
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws IllegalArgumentException {
        for (File fileStorageSource : storageFrom.getFiles()) {

            try {
                put(storageTo, fileStorageSource);
                delete(storageFrom, fileStorageSource);
            } catch (Exception e) {
                System.out.println("Не все файлы  с хранилища id:  " + storageFrom.getId() + " перемещены в  хранилище id : " + storageTo.getId());
                throw new RuntimeException("Не все файлы  с хранилища id:  " + storageFrom.getId() + " перемещены в  хранилище id : " + storageTo.getId());
            }
        }
    }

    File transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {

            File founded = validate.getFileByID(id, storageFrom.getFiles());
            if (validate.fileIsPresentByID(storageFrom, id)) {
                put(storageTo, founded);
                delete(storageFrom, founded);
                return founded;
            }
            return null;
    }

    private File[] addFileToArray(Storage storage, File file) throws IllegalArgumentException {

        File[] newArrayFiles = new File[storage.getFiles().length + 1];
        for (int i = 0; i < storage.getFiles().length; i++) {
            newArrayFiles[i] = storage.getFiles()[i];
        }
        newArrayFiles[newArrayFiles.length - 1] = file;
        return newArrayFiles;

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




