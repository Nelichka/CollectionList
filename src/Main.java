import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> listshop = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int number = -1;
        do {
            showList();
            String s = sc.nextLine();
            try {
                number = Integer.parseInt(s);
                switch (number) {
                    case 1 -> addL();
                    case 2 -> showL();
                    case 3 -> deleteL();
                    case 4 -> searchL();
                }
            } catch (NumberFormatException e) {
            }
        }
        while (number != 0); // Конец

    }


    private static void addL() {
        System.out.println("Какую покупку хотите добавить?");

        listshop.add(sc.nextLine());
        System.out.printf("Итого в списке покупок:%3d\n", listshop.size());
    }

    private static void showL() {
        System.out.println("Список покупок:");
        for (int i = 0; i < listshop.size(); i++) {
            System.out.printf("%3d.%-12s\n", i + 1, listshop.get(i));

        }
    }

    private static void deleteL() {
        int index;
        showL();
        System.out.println("Какую хотите удалить? Введите номер или название");
        String s = sc.nextLine();
        try {
            index = Integer.parseInt(s) - 1;
        } catch (NumberFormatException e) {
            index = listshop.indexOf(s);
        }
        listshop.remove(index);
    }

    private static void searchL() {
        System.out.println("Введите текст для поиска:");
        String s = sc.nextLine().toLowerCase();
        System.out.println("Найдено:");
        for (int i = 0; i < listshop.size(); i++) {
            if (listshop.get(i).toLowerCase().contains(s)) {
                System.out.printf("%3d.%-12s\n", i + 1, listshop.get(i));
            }
        }
    }

    private static void showList() {
        System.out.println("<1> - Добавить");
        System.out.println("<2> - Показать");
        System.out.println("<3> - Удалить");
        System.out.println("<4> - Найти");
        System.out.println("<0> - Конец работы");
        System.out.println("Выберите операцию: ");

    }
}