import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;

public class DIGITY {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "text.txt";
        boolean running = true;

        while (running) {
            System.out.println("\n*********************************");
            System.out.println("*       РЕДАКТОР ТЕКСТА         *");
            System.out.println("*********************************");
            System.out.println("* 1. Записать в файл             *");
            System.out.println("* 2. Прочитать файл              *");
            System.out.println("* 3. Выйти                      *");
            System.out.println("*********************************");
            System.out.print("Выберите пункт меню (1-3): ");
            System.out.println("https://www.myinstants.com/ru/instant/family-guy-quagmires-giggity-giggity-goo-88334/");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("\n*********** Запись в файл ***********");
                System.out.println("* 1. Добавить в конец файла         *");
                System.out.println("* 2. Перезаписать файл              *");
                System.out.println("*************************************");
                System.out.print("Выберите режим записи (1-2): ");

                String mode = scanner.nextLine();
                boolean append = mode.equals("1");

                System.out.println("Введите строку для записи:");
                String line = scanner.nextLine();

                try {
                    FileWriter writer = new FileWriter(fileName, append);
                    writer.write(line + "\n");
                    writer.close();
                    System.out.println("Запись выполнена успешно!");
                } catch (Exception e) {
                    System.out.println("Ошибка записи: " + e);
                }
            }
            else if (choice.equals("2")) {
                try {
                    File file = new File(fileName);
                    if (!file.exists()) {
                        System.out.println("Файл не существует!");
                        continue;
                    }

                    FileReader reader = new FileReader(file);
                    char[] buffer = new char[1024];
                    int charRead;

                    System.out.println("\n********** СОДЕРЖИМОЕ ФАЙЛА **********");

                    while ((charRead = reader.read(buffer)) != -1) {
                        for (int i = 0; i < charRead; i++) {
                            System.out.print(buffer[i]);
                        }
                    }

                    System.out.println("\n***************************************");
                    reader.close();
                } catch (Exception e) {
                    System.out.println("Ошибка чтения: " + e);
                }
            }
            else if (choice.equals("3")) {
                running = false;
                System.out.println("Программа завершена.");
            }
            else {
                System.out.println("Неверный выбор, попробуйте снова.");
            }
        }

        scanner.close();
    }
}
