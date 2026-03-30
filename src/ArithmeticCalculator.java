import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {

    private List<Integer> results = new ArrayList<>();

    public int calculate(int number1, int number2, char operator) {
        int result = 0;
        boolean isValid = true;

        OperatorType operatorType = OperatorType.fromSymbol(operator);

        if(operatorType == null) {
            System.out.println("잘못된 연산기호 입니다");
            return result;
        }

        switch (operatorType) {
            case ADD:
                result = number1 + number2;
                break;

            case SUBTRACTION:
                result = number1 - number2;
                break;

            case MULTIPLY:
                result = number1 * number2;
                break;

            case DIVIDE:
                if (number2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
                    isValid = false;
                } else {
                    result = number1 / number2;
                }
                break;
        }


        if (isValid) {
            results.add(result);
        }
        return result;
    }

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }

    public Integer removeFirst() {
        if(!results.isEmpty()){
            return results.remove(0);
        }
        return null;
    }
}
