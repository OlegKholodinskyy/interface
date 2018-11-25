package lesson19.fileTransferException;

public class Controller {
    void put(Storage storage, File file) {
        if (!fileIsPresent(storage, file)) {
            storage.setFiles(addFileToArray(storage.getFiles(), file));
        }
    }

    private boolean fileIsPresent(Storage storage, File file) {
        boolean isPresent = false;
        for (File checkedFile : storage.getFiles()) {
            if (file.equals(checkedFile))
                isPresent = true;
        }
        return isPresent;
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
                    newArrayFiles[tmp] = files[i];
                    tmp++;
                } else {
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
            if (!fileIsPresent(storageTo, fileStorageSource)) {
                put(storageTo, fileStorageSource);
                delete(storageFrom, fileStorageSource);
            }
        }
    }

    void transferFile(Storage storageFrom, Storage storageTo, long id) {
        if (fileIsPresentByID(storageFrom, id) && !fileIsPresentByID(storageTo, id)) {
            File founded  = getFileByID(id, storageFrom);
            put(storageTo, founded);
            delete(storageFrom,founded);
        }

    }

    private File getFileByID(long id, Storage storageFrom) {
        for(File founded : storageFrom.getFiles()){
            if (founded.getId() == id){
                return founded;
            }
        }
        return null;
    }

    private boolean fileIsPresentByID(Storage storageFrom, long id) {
        boolean isPresent=false;
        for (File checkedFile : storageFrom.getFiles()){
            if (checkedFile.getId()==id)
              isPresent = true;
        }
        return isPresent;
    }

}

