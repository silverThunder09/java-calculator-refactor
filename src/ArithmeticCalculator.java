import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {

    private final List<Double> results = new ArrayList<>();

    public double calculate(T number1, T number2, char operator) {
        double result = 0;

        OperatorType operatorType = OperatorType.fromSymbol(operator);

        if (operatorType == null) {
            // 잘못된 연산자일 경우 예외 발생
            throw new IllegalArgumentException("잘못된 연산기호입니다.");
        }

        switch (operatorType) {
            case ADD:
                result = number1.doubleValue() + number2.doubleValue();
                break;

            case SUBTRACTION:
                result = number1.doubleValue() - number2.doubleValue();
                break;

            case MULTIPLY:
                result = number1.doubleValue() * number2.doubleValue();
                break;

            case DIVIDE:
                // 0으로 나누는 연산은 허용하지 않으므로 예외 발생
                if (number2.doubleValue() == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
                }
                result = number1.doubleValue() / number2.doubleValue();
                break;
        }

        results.add(result);
        return result;
    }


    // 저장된 결과 목록의 복사본을 반환
    public List<Double> getResults() {
        return new ArrayList<>(results);
    }

    // 저장된 모든 결과를 삭제
    public void clearResults() {
        results.clear();
    }

    // 가장 먼저 저장된 결과 하나를 삭제
    public Double removeFirst() {
        if (results.isEmpty()) {
            return null;
        }
        return results.remove(0);
    }

    // 저장된 결과들 중 입력값보다 큰 값만 조회(람다와 스트림 이용)
    public List<Double> getResultsGreaterThan(double value) {
        return results.stream()
                .filter(result -> result > value)
                .collect(Collectors.toList());
    }
}
