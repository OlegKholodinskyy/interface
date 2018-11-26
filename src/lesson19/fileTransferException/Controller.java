package lesson19.fileTransferException;

public class Controller {
    public File put(Storage storage, File file) throws Exception {

        if (fileIsPresent(storage, file) || !checkFormats(storage, file) || !checkMaxSize(storage, file)) {
            throw new Exception("Не удалось добавить файл с id : \" + file.getId() + \" в хранилеще id : \" + storage.getId()");
        }
        storage.setFiles(addFileToArray(storage.getFiles(), file));
        return file;
    }

    public File delete(Storage storage, File file) throws Exception {
        if (!fileIsPresent(storage, file)) {
            throw new Exception("Не удалось удалить файл с id :" + file.getId() + " из хранилеща id : " + storage.getId());
        }
        storage.setFiles(deleteFileFromArray(storage.getFiles(), file));
        return file;
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        for (File fileStorageSource : storageFrom.getFiles()) {
            if (fileIsPresent(storageTo, fileStorageSource) || !checkFormats(storageTo, fileStorageSource)) {
                throw new Exception("Не удалсь переместить все файлы с хранилища " + storageFrom.getId() + " в хранилище " + storageTo.getId());
            } else {
                put(storageTo, fileStorageSource);
                delete(storageFrom, fileStorageSource);
            }
        }
    }

    void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        File founded = getFileByID(id, storageFrom);
        if (!fileIsPresentByID(storageFrom, id) || fileIsPresentByID(storageTo, id) || !checkFormats(storageTo, founded)) {
            throw new Exception("Не вдалося перенести файл");
        } else {
            put(storageTo, founded);
            delete(storageFrom, founded);
        }
    }



    private boolean checkMaxSize(Storage storage, File file) throws Exception {
        boolean sizeIsGood = false;
        if (storage.getStorageSize() > getCurrentSizeOfStorage(storage) + file.getSize()) {
            sizeIsGood = true;
        } else {
            throw new Exception("Не удалось добавить файл с id : " + file.getId() + " в хранилеще id : " + storage.getId() + " превышен размер хранилища");
        }
        return sizeIsGood;
    }

    private long getCurrentSizeOfStorage(Storage storage) {
        long size = 0;
        for (File file : storage.getFiles()) {
            size = size + file.getSize();
        }
        return size;
    }

    private boolean checkFormats(Storage storage, File file) throws Exception {
        boolean formatIsInOrder = false;
        if (!storage.getFormatsSupported().equals(file.getFormat())) {
            formatIsInOrder = true;
        } else {
            throw new Exception("Не удалось добавить файл с id : " + file.getId() + " в хранилеще id : " + storage.getId() + "не подходит формат файла");
        }
        return formatIsInOrder;
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

    private File getFileByID(long id, Storage storageFrom) {
        for (File founded : storageFrom.getFiles()) {
            if (founded.getId() == id) {
                return founded;
            }
        }
        return null;
    }

    private boolean fileIsPresentByID(Storage storageFrom, long id) {
        boolean isPresent = false;
        for (File checkedFile : storageFrom.getFiles()) {
            if (checkedFile.getId() == id)
                isPresent = true;
        }
        return isPresent;
    }

}

