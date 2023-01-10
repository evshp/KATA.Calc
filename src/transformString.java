import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.regex.Pattern;

public class transformString {

    //Поля
    private String condition;
    private boolean found = false;

    private final String[] arabicNumb = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private final String[] romanNumerals = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    private int x;
    private int y;

    //Конструктор
    public transformString(String condition) {
        this.condition = condition;


    }

    //Методы
    ///Метод разбивающий строку на массив строк.
    public String[] calc() {
        String str1 = this.condition;
        Pattern pattern = Pattern.compile("\\s*(\\s|,|!|\\.)\\s*");
        str1 = str1.trim();
        String[] words = pattern.split(str1);
        words = checkException(words);
        return words;

    }

    //Проверка на соблюдение условий необходимых для выполнения вычеслений
    private String[] checkException(String[] Words) {

        String[] words = Words;


        if (words.length > 3) try {
            throw new IOException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } catch (IOException e) {
            System.out.println("Вводите данные в формате: 1 + 1");
            throw new RuntimeException(e);
        }


        if (words.length <= 1) try {
            throw new IOException("Строка не является математической операцией");
        } catch (IOException e) {
            System.out.println("Вводите данные в формате: 1 + 1\n Неверный формат ввода данных");
            throw new RuntimeException(e);
        }


        if (words[1].equals("+") || words[1].equals("-") || words[1].equals("*") || words[1].equals("/")) {

        } else {
            try {
                throw new IOException("Оператор не является математической операцией");
            } catch (IOException e) {
                System.out.println("Используйте (+, -, /, *) в качесте математического оператора");
                throw new RuntimeException(e);
            }

        }

        try {
            // Проверяем что ввел пользователь цифры или буквы, если буквы пропускаем перебор целочисленных значений
            x = Integer.parseInt(words[0]);
            y = Integer.parseInt((words[2]));

            if (x <= 10 & x >= 1 & y >= 1 & y <= 10) {
                //Проверяем находится ли введеные числа в диапазоне от 1 до 10
                for (int i = 0; i < 10; i++) {

                    if (words[0].equals(arabicNumb[i])) {

                        for (int a = 0; a < 10; a++) {

                            if (words[2].equals(arabicNumb[a])) {

                                words = append(words, "a");
                                return words;

                            }

                        }

                    }
                }


            } else {
                System.out.println("На вход принимаются числа до 10 включительно");
                throw new IOException("Введены числа больше 10");
            }

        //Проверяем римские цифры на соотвествие условий
        } catch (NumberFormatException | IOException ex) {
            found = true;
            for (int i = 0; i < 10; i++)
            {

                if (words[0].equals(romanNumerals[i]))
                {
                    found = false;
                    for (int a = 0; a < 10; a++)
                    {

                        if (words[2].equals(romanNumerals[a]))
                        {

                            words = append(words, "r");
                            found = true;
                            return words;

                        }
                    }
                }

            }
            if (found){
                try {
                    throw new IOException("Используются одновременно разные системы счисления " +
                            "или введеные значения не соотвествуют арабской и римской системе исчесления");
                } catch (IOException e) {
                    System.out.println("При вводе данных операнды дожны быть в одной системе исчесления и от 1 до 10 (I...X) включительно");
                    throw new RuntimeException(e);
                }

            }

        }

        return words;
    }


    //Метод копирующий матрицу и увеличивающий ее размер
    private static <T > T[]append(T[]arr, T element){
        T[] array = Arrays.copyOf(arr, arr.length + 1);
        array[arr.length] = element;
        return array;
    }

}





