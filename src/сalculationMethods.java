import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;

public class сalculationMethods {


   //Поля
    private int x, y;
    private String symb;
    private  String r;


    // Конструктор
   public сalculationMethods (int x, int y, String symb){
       this.x = x;
       this.y = y;
       this.symb = symb;
    }

    // Перегрузка конструктора
    public сalculationMethods (int x, int y, String symb, String r){
        this.x = x;
        this.y = y;
        this.symb = symb;
        this.r = r;

    }



    //Метод осущесвтялющий математические операции с арабскими цифрами
    public int startCalculation (){
       int result = 0;

        switch (symb){

            case "+": result = x + y;
            return result;


            case "-": result = x - y;

            return result;

            case "*": result = x * y;
                return result;

            // Делим и округляем в большую сторону
            case "/": result = x / y;
                result = (int)Math.ceil(0.5);
                return result;

            default: break;


        }


       return result;
    }


    //Метод осущесвтялющий математические операции с римскими цифрами
    public void startCalculationRomanNumb (){
        int result = 0;
        String rom =  this.r;

        switch (symb){

            case "+": result = x + y;
               break;


            case "-": result = x - y;

            if (result < 1){  try {
                throw new IOException("В римской системе нет отрицательных чисел");
            } catch (IOException e) {
                System.out.println("Введите коректные данные");
                throw new RuntimeException(e);
            }

            } else
            {
                break;
            }


            case "*": result = x * y;
                break;

            // Делим и округляем в большую сторону
            case "/": result = x / y;
                      result = (int)Math.ceil(0.5);
                break;

            default: break;
        }
        System.out.println("Ответ в римской системе исчесления: " + RomanNumerals.arabicToRoman(result));
    }






}
