import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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
            char operator = sc.next().charAt(0);
            int result = 0;
            boolean isValid = true;

            switch (operator) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    if (number2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
                        isValid = false;
                    } else {
                        result = number1 / number2;
                    }
                    break;
                default:
                    System.out.println("잘못된 연산기호 입니다");
                    isValid = false;
                    break;
            }
            if (isValid) {
                System.out.println("결과 값: " + result);
            }

            System.out.print("더 계산하시겠습니까? (exit 입력시 종료)");

            String answer = sc.next();
            if (answer.equalsIgnoreCase("exit")) {
                break;
            }
        }
    }
}



