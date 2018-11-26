package lesson19.fileTransferException;

public class Controller {

    public File put(Storage storage, File file) throws Exception {
        try {
            storage.setFiles(addFileToArray(storage, file));
        } catch (Exception e) {
            System.out.println(" put is failed ");
        }finally {
            return file;
        }
    }

    public File delete(Storage storage, File file) throws Exception {
        try {
            storage.setFiles(deleteFileFromArray(storage, file));
        } catch (Exception e) {
        }
        return file;
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        for (File fileStorageSource : storageFrom.getFiles()) {

            try {
                put(storageTo, fileStorageSource);
                delete(storageFrom, fileStorageSource);
            }
            catch (Exception e){
                System.out.println(" put all is failed ");
            }
        }
    }

    void transferFile(Storage storageFrom, Storage storageTo, long id) {
        try {
            File founded = getFileByID(id, storageFrom.getFiles());
            if (fileIsPresentByID(storageFrom, id)) {
                put(storageTo, founded);
                delete(storageFrom, founded);
            }
        } catch (Exception e) {
            System.out.println(" transferFile is failed ");
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

    private File[] addFileToArray(Storage storage, File file) throws Exception {

        if (file.equals(null) || fileIsPresent(storage, file) || !checkFormats(storage, file) || !checkMaxSize(storage, file)) {
            throw new Exception("file not added");
        } else {
            File[] newArrayFiles = new File[storage.getFiles().length + 1];
            for (int i = 0; i < storage.getFiles().length; i++) {
                newArrayFiles[i] = storage.getFiles()[i];
            }
            newArrayFiles[newArrayFiles.length - 1] = file;
            return newArrayFiles;
        }
    }

    private File[] deleteFileFromArray(Storage storage, File file) throws Exception {
        if (!fileIsPresent(storage, file)) {
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

    private File getFileByID(long id, File[] files) {
        for (File founded : files) {
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

