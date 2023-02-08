import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileOrchestrator extends FolderOrchestrator implements ImageFileDatabase, FileDatabase {
    public void saveAllListOfFiles(List<MFile> mFileList) {

    }

    public void saveAllListOfImagesFiles(List<MFile> mImageFileList) {

    }


    @Override
    public void saveFile(String directory, String content, MFileAnnotationTypeEnum type, String nameFile) {


        if (type.equals(MFileAnnotationTypeEnum.REMINDER))
            directory += "\\reminders";

        else if (type.equals(MFileAnnotationTypeEnum.IMPORTANT))
            directory += "\\important";

        File dir = new File(directory);
        dir.mkdir();

        File file = new File(dir, nameFile + ".txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void recoveryFile(String directory, String nameFile) {

    }

    @Override
    public void removeFile(String directory, String nameFile, MFileAnnotationTypeEnum type) {

    }

    @Override
    public void listAllFiles(String directory) {

    }


    @Override
    public void saveImageFile(String directory, String content, String nameFile) {

    }

    @Override
    public void recoveryImageFile(String directory) {

    }

    @Override
    public void removeImageFile(String directory, String nameFile) {

    }

    @Override
    public void listAllImageFiles(String directory) {

    }
}
