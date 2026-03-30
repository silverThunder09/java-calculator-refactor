import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArithmeticCalculator calculator = new ArithmeticCalculator();

        while (true) {
            int number1;
            while (true) {
                try {
                    System.out.print("첫 번째 정수를 입력해주세요: ");
                    number1 = sc.nextInt();
                    if (number1 < 0) {
                        System.out.println("0 이상의 정수를 입력해주세요");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력해주세요");
                    sc.nextLine();

                }
            }

            int number2;
            char operator;
            while (true) {
                try {
                    System.out.print("두 번째 정수를 입력해주세요: ");
                    number2 = sc.nextInt();
                    if (number2 < 0) {
                        System.out.println("0 이상의 정수를 입력해주세요");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력해주세요");
                    sc.nextLine();
                }
            }

            System.out.print("사칙연산 기호를 입력해주세요: ");

            operator = sc.next().charAt(0);
            int result = calculator.calculate(number1, number2, operator);
            System.out.println("결과 값:" + result);
            System.out.println("결과 저장 목록: " + calculator.getResults());

            System.out.print("더 계산하시겠습니까? (exit 입력시 종료 , remove 입력시 첫번째 결과 삭제): ");
            String answer = sc.next();
            if (answer.equalsIgnoreCase("exit")) {
                calculator.setResults(new ArrayList<>());
                System.out.println("결과 저장 목록 초기화 :" + calculator.getResults());
                break;

            }else if(answer.equalsIgnoreCase("remove")) {
                Integer removed = calculator.removeFirst();
                if (removed != null) {
                    System.out.println("가장 먼저 저장된 결과: " + removed + "를 삭제하였습니다.");
                    System.out.println("현재 결과 목록: " +calculator.getResults());
                }
            }
        }
        sc.close();
    }
}



