import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HandlerFile extends FileOrchestrator{

    static Scanner scanner = new Scanner(System.in);
    static FileOrchestrator file = new FileOrchestrator();

    public static void main(String[] args){

        menuPrincipal();

        File dir = new File("Arquivos");
        boolean mkdir = dir.mkdir();

        File file = new File(dir, "arquivo.mkv");
        try {
            boolean newFile = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void menuPrincipal(){
        do {
            limparTela();
            System.out.println("########## BEM VINDO AO GERENCIADOR DE ARQUIVOS ##########");
            System.out.println("########## MENU PRINCIPAL ##########");
            System.out.println("1 - Salvar arquivo");
            System.out.println("2 - Remover arquivo");
            System.out.println("3 - Listar arquivo");
            System.out.println("0 - Sair da aplicação");
            System.out.print("Selecione uma das opções acima: ");
            Integer op = Integer.parseInt(scanner.nextLine());

            switch (op){
                case 1:
                    menuSalvar();
                    break;
                case 2:
                    System.out.println("remover");
                case 3:
                    System.out.println("listar");
                case 0:
                    return;
            }
        }while (true);
    }

    public static void menuSalvar() {
        limparTela();

        System.out.println("########## MENU SALVAR ##########");
        System.out.println();

        System.out.print("Digite o diretório que deseja salvar seu arquivo: ");
        String path = scanner.nextLine();
        System.out.print("Digite o nome do arquivo que deseja salvar: ");
        String nameFile = scanner.nextLine();

        MFileAnnotationTypeEnum type = minimenuTipo();

        if (type != MFileAnnotationTypeEnum.IMAGE){
            System.out.println("Digite a mensagem de dentro do arquivo de texto:");
            String content = scanner.nextLine();

            file.saveFile(path, content, type, nameFile);

        }else {
            System.out.println("Digite a URL ou o caminho de onde a imagem deseja capturar a imagem:");
            String content = scanner.nextLine();

            file.saveImageFile(path, content, nameFile);
        }
    }

    private static MFileAnnotationTypeEnum minimenuTipo() {

        System.out.println("1 - Arquivo para lembrete");
        System.out.println("2 - Arquivo importante");
        System.out.println("3 - Arquivo de imagem");
        System.out.println("4 - Arquivo simples");
        System.out.print("Selecione o tipo de arquivo que deseja salvar: ");
        int op = Integer.parseInt(scanner.nextLine());

        switch (op){
            case 1:
                return MFileAnnotationTypeEnum.REMINDER;

            case 2:
                return MFileAnnotationTypeEnum.IMPORTANT;

            case 3:
                return MFileAnnotationTypeEnum.IMAGE;

            default:
                return MFileAnnotationTypeEnum.SIMPLE;
        }
    }


    protected static void limparTela() {
        for (int i = 0; i <= 20; i++){
            System.out.println();
        }
    }
}