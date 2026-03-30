import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Integer> results = new ArrayList<>();

    public int calculate(int number1, int number2, char operator) {
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

    public void removeFirst() {
        if(!results.isEmpty()){
            System.out.println("가장 먼저 저장된 결과: " + results.get(0) + "를 삭제하였습니다.");
            results.remove(0);
        }
    }
}
