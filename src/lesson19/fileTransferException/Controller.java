package lesson19.fileTransferException;

public class Controller {
    public void put(Storage storage, File file) {

      /*  if (!fileIsPresent(storage, file) && checkFormats(storage, file)&&  checkMaxSize(storage,file)) {
            storage.setFiles(addFileToArray(storage.getFiles(), file));
        } else {
            throw new Exception("Не удалось добавить файл с id : " + file.getId() + " в хранилеще id : " + storage.id);
        }*/

        try {
            if (!fileIsPresent(storage, file) && checkFormats(storage, file) && checkMaxSize(storage, file)) {
                storage.setFiles(addFileToArray(storage.getFiles(), file));
            }
        } catch (Exception e) {
            System.out.println("Не удалось добавить файл с id : " + file.getId() + " в хранилеще id : " + storage.getId());
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

    void delete(Storage storage, File file) {
        try {
            if (fileIsPresent(storage, file)) {
                storage.setFiles(deleteFileFromArray(storage.getFiles(), file));
            }
        } catch (Exception e) {
            System.out.println("Не удалось удалить файл с id :" + file.getId() + " из хранилеща id : " + storage.getId() );
        }
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
            try {
                if (!fileIsPresent(storageTo, fileStorageSource) && checkFormats(storageTo, fileStorageSource)) {
                    try {
                        put(storageTo, fileStorageSource);
                        delete(storageFrom, fileStorageSource);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            } catch (Exception e) {
                System.out.println("Не удалсь переместить все файлы с хранилища "  + storageFrom.getId() + " в хранилище " + storageTo.getId());
            }
        }
    }

    void transferFile(Storage storageFrom, Storage storageTo, long id) {
        File founded = getFileByID(id, storageFrom);
        try {
            if (fileIsPresentByID(storageFrom, id) && !fileIsPresentByID(storageTo, id) && checkFormats(storageTo, founded)) {
                try {
                    put(storageTo, founded);
                    delete(storageFrom, founded);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

