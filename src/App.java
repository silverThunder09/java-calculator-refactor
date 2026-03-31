import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        while (true) {
            double number1;
            while (true) {
                try {
                    System.out.print("첫 번째 숫자를 입력해주세요: ");
                    number1 = sc.nextDouble();
                    if (number1 < 0) {
                        System.out.println("0 이상의 숫자를 입력해주세요");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력해주세요");
                    sc.nextLine();

                }
            }

            double number2;
            char operator;
            while (true) {
                try {
                    System.out.print("두 번째 숫자를 입력해주세요: ");
                    number2 = sc.nextDouble();
                    if (number2 < 0) {
                        System.out.println("0 이상의 숫자를 입력해주세요");
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
            try {
                // 연산 수행
                double result = calculator.calculate(number1, number2, operator);

                // 연산이 성공한 경우에만 결과와 저장 목록 출력
                System.out.println("결과 값:" + result);

                List<Double> results = calculator.getResults();
                System.out.println("결과 저장 목록: " + results);

                if (results.size() >= 2) {
                    System.out.print("조회 기준값을 입력해주세요: ");
                    double searchValue = sc.nextDouble();
                    System.out.println("입력값보다 큰 저장 결과들: " + calculator.getResultsGreaterThan(searchValue));
                }


            } catch (IllegalArgumentException | ArithmeticException e) {
                // 잘못된 연산자 또는 0으로 나누는 경우를 명확히 구분하여 처리
                System.out.println("연산 실패: " + e.getMessage());

            }

            while (true) {
                System.out.print("더 계산하시겠습니까? (exit 입력시 종료 , remove 입력시 첫번째 결과 삭제): ");
                String answer = sc.next();

                // exit 입력 시 저장 목록 초기화 후 프로그램 종료
                if (answer.equalsIgnoreCase("exit")) {
                    calculator.clearResults();
                    System.out.println("결과 저장 목록 초기화 :" + calculator.getResults());
                    sc.close();
                    return;
                }

                // remove 입력 시 가장 먼저 저장된 결과 하나 삭제
                if (answer.equalsIgnoreCase("remove")) {
                    Double removed = calculator.removeFirst();
                    if (removed != null) {
                        System.out.println("가장 먼저 저장된 결과: " + removed + "를 삭제하였습니다.");
                        System.out.println("현재 결과 목록: " + calculator.getResults());
                    } else {
                        System.out.println("삭제할 결과가 없습니다.");
                    }
                    continue;
                }
                break;
            }
        }
    }
}



