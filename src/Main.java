import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;


/* Реализован калькулятор по следующему алгоритму:
* Пользователь вводит в одну строку два операнда и один оператор, далее в классе "transformString"
* реализован метод, который обрабатыват строку на возможные ошибки и выдает исключения, если все хорошо
* возвращает строку готовую, из которой мы уже вытаскиваем целочисленные значения двумя методами в зависимости от алфавита
* к котору относятся операнды, далее мы передаем целочисленные значения и  вспомогательные String в методы осуществляющие
* математические операции */

//RomanNumerals - класс, который хранит в себе значения римских цифр, необходим для осуществления перевода из разных систем исчесления
//transformString - класс, который хранит в себе методы осуществляющие обработку введеных пользователем данных
//calculationMethods - класс, который хранит в себе методы осуществляющие математические операции

public class Main {
    public static void main(String[] args) throws IOException {

        int x;
        int y;
        String symb;
        String result;
        //Вводим исходные данные
        Scanner in = new Scanner(System.in);
        System.out.println("Добро пожаловать в однострочный калькулятор!\n" +
                "Калькулятор умеет работать с арабскими и римскими числами и принимает на вход числа от 1 до 10 включительно.\n" +
                "Формат ввода чисел должен быть следующим:\n1. a + b\n2. a - b\n3. a * b\n4. a / b.");
        System.out.println("Введите необходимую операцию соблюдая формат ввода:");
        String str1 = in.nextLine();

        //Создаем объект (строку)
        transformString transformString = new transformString(str1);

        //Вызываем метод преобразования исходнной строки в массив строк необходимый для проведения матетических операций
        String [] finalStr = transformString.calc();

        //Осуществляем выборку операций с римскими ("r") или арабскими ("a") символами.
        if (finalStr[3].equals("a")) {

            x = Integer.parseInt(finalStr[0]);
            y = Integer.parseInt(finalStr[2]);
            symb = finalStr[1];

            сalculationMethods сalculationArabicMethods = new сalculationMethods(x, y, symb);
            System.out.println("Ответ: " + сalculationArabicMethods.startCalculation());


        }

        if (finalStr[3].equals("r")) {
            ///Вытаскиваем целочисленные значения римских цифр от I до X
           RomanNumerals value1 = RomanNumerals.valueOf(finalStr[0]);
           RomanNumerals value2 = RomanNumerals.valueOf(finalStr[2]);
           x = value1.getValue();
           y = value2.getValue();
           symb = finalStr[1];

           //Записываем данные в объект и вызываем метод рассчета римских цифр
           сalculationMethods сalculationMethodsRomanToArabic = new сalculationMethods(x, y, symb, "r");
           сalculationMethodsRomanToArabic.startCalculationRomanNumb();





                }

























    }
}