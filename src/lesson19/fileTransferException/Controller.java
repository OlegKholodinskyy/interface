package lesson19.fileTransferException;

public class Controller {

    Validate validate = new Validate();

    public File put(Storage storage, File file) throws Exception {
        if (validate.isValidArgumentsPuttMethod( storage, file )) {
            storage.setFiles(addFileToArray(storage, file));
            return file;
        }
        else
            return file;
    }

    public File delete(Storage storage, File file) throws Exception {
        try {
            storage.setFiles(deleteFileFromArray(storage, file));
        } catch (IllegalArgumentException e) {
            System.out.println("Файл id: " + file.getId() + " не удалён с  хранилища id : " + storage.getId());
            throw e;
            //       throw new RuntimeException("Файл id: " +file.getId() + " не удалён с  хранилища id : " + storage.getId());
        }
        return file;
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

    void transferFile(Storage storageFrom, Storage storageTo, long id) throws IllegalArgumentException {
        try {
            File founded = validate.getFileByID(id, storageFrom.getFiles());
            if (validate.fileIsPresentByID(storageFrom, id)) {
                put(storageTo, founded);
                delete(storageFrom, founded);
            }
        } catch (Exception e) {
            System.out.println("Файл id: " + id + " не перемещн в  хранилище id : " + storageTo.getId());
            throw new IllegalArgumentException("Файл id: " + id + " не перемещн в  хранилище id : " + storageTo.getId());
        }
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
        if (!validate.fileIsPresent(storage, file) && !validate.chechName(file)) {
            System.out.println("Не удалось удалить файл с id :" + file.getId() + " из хранилеща id : " + storage.getId());
            throw new Exception("Не удалось удалить файл с id :" + file.getId() + " из хранилеща id : " + storage.getId());
        } else {

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


}

