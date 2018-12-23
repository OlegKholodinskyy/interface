package lesson29;

import java.util.Objects;

public class File {
    private String fileName;
    private long sizeInButes;

    public File(String fileName, long sizeInButes) {
        this.fileName = fileName;
        this.sizeInButes = sizeInButes;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", sizeInButes=" + sizeInButes +
                '}' + "\n";
    }

    public String getFileName() {
        return fileName;
    }

    public long getSizeInButes() {
        return sizeInButes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return sizeInButes == file.sizeInButes &&
                Objects.equals(fileName, file.fileName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fileName, sizeInButes);
    }
}
