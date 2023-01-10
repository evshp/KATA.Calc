import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNumerals {
    I(1), II(2), III(3), IV(4), V(5),
    VI(6), VII(7), VIII(8), IX(9), X(10),
    XL (40), L(50), XC(90), C(100);

    private int value;


    RomanNumerals(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }



    //Получаем и сортируем List от большего к меньшему и возращаем список
    public static List<RomanNumerals> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumerals e) -> e.value).reversed())
                .collect(Collectors.toList());
    }




    //Перебераем List от большего к меньшему при соблюдение условий записываем символ и ищем остаток от
    // первоначального числа number.
    public static String arabicToRoman(int number) {

        List<RomanNumerals> romanNumerals = RomanNumerals.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumerals currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }




}
