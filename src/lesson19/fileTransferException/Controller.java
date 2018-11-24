package lesson19.fileTransferException;

public class Controller {
    void put(Storage storage, File file) {
        storage.setFiles(addFileToArray(storage.getFiles(), file));
    }

    private File[] addFileToArray(File[] files, File file) {
        File[] newArrayFiles = new File[files.length + 1];
        for (int i = 0; i < files.length; i++) {
            newArrayFiles[i] = files[i];
        }
        newArrayFiles[newArrayFiles.length - 1] = file;
        return newArrayFiles;
    }

    void delete(Storage storage, File file) {
        storage.setFiles(deleteFileFromArray(storage.getFiles(), file));
    }

    private File[] deleteFileFromArray(File[] files, File file) {
        File[] newArrayFiles = new File[files.length - 1];
        int countMatches = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].equals(file))
                countMatches++;
        }

        if (countMatches != 0) {
            int tmp = 0;
            for (int i = 0; i < files.length; i++) {
                if (!files[i].equals(file)) {
                    newArrayFiles[i] = files[tmp];
                    tmp++;
                } else {
                    tmp = tmp + 2;
                    continue;
                }
            }
            return newArrayFiles;
        } else {
            return files;
        }
    }

    void transferAll(Storage storageFrom, Storage storageTo) {
        for (File fileStorageSource : storageFrom.getFiles()) {
            put(storageTo, fileStorageSource);
        }
        for (File fileStorageSource : storageFrom.getFiles()) {
            delete(storageFrom, fileStorageSource);
        }
    }

    void transferFile(Storage storageFrom, Storage storageTo, long id) {
        File founded = null;
        for (File file : storageFrom.getFiles()) {
            if (file.getId() == id) {
                put(storageTo, file);
                founded = file;
            }
        }

        if (founded != null) {
            delete(storageFrom, founded);
        }
    }


}
