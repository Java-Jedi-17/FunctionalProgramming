package ru.netology.task1;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        try {
            int b = calc.minus.apply(1, 1);
            int c = calc.devide.apply(a, b); // ArithmeticException. Делить на 0 нельзя
            calc.println.accept(c);
        } catch (ArithmeticException exception) {
            System.out.println("Делить на 0 нельзя!");
        } finally {

        }
    }
}


/*
1 вариант: использовать конструкцию try - catch для обработки исключения (реализовал выше);
2 вариант: ограничить переменную devide в классе ru.netology.task1.Calculator,
чтобы при передаче параметра y = 0 появлялось сообщение об ошибке:

 BinaryOperator<Integer> devide = (x, y) ->
            y == 0 ? Integer.parseInt("Делить на 0 нельзя") : x/y;

 Тогда обработка исключений будет выглядеть так:

 try {
      int b = calc.minus.apply(1, 1);
      int c = calc.devide.apply(a, b); // ArithmeticException. Делить на 0 нельзя
      calc.println.accept(c);
 } catch (ArithmeticException | NumberFormatException exception) {
      System.out.println("Делить на 0 нельзя!");
 }
                                                                            */