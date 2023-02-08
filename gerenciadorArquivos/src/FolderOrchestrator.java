import java.io.File;
import java.util.List;

public class FolderOrchestrator implements FolderManagement {

    public void createFolders(List<String> mListPaths) {

    }
    public void removeFolders(List<String> mListPaths) {

    }

    @Override
    public void createAFolder(String path) {
        File dir = new File(path);
        dir.mkdir();
    }

    @Override
    public void removeAFolder(String path) {

    }

    @Override
    public void listAllFoldersCreated() {

    }
}