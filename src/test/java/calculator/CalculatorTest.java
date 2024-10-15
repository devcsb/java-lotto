package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  @DisplayName("null 입력 시 IllegalArgumentException을 반환한다.")
  @Test
  void inputNullThrowsException() {

    assertThatThrownBy(() -> {
      Calculator.calculate(null);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("빈문자열 입력 시 IllegalArgumentException을 반환한다.")
  @Test
  void inputNullStringThrowsException() {

    assertThatThrownBy(() -> {
      Calculator.calculate("");
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("두 숫자의 덧셈 연산이 잘 수행된다.")
  @Test
  void addCorrectly() {
    int result = Calculator.calculate("2 + 3");
    assertThat(result).isEqualTo(5);
  }

  @DisplayName("두 숫자의 뺄셈 연산이 잘 수행된다.")
  @Test
  void subtractCorrectly() {
    int result = Calculator.calculate("2 - 1");
    assertThat(result).isEqualTo(1);
  }

  @DisplayName("두 숫자의 곱셈 연산이 잘 수행된다.")
  @Test
  void multiplyCorrectly() {
    int result = Calculator.calculate("2 * 3");
    assertThat(result).isEqualTo(6);
  }

  @DisplayName("두 숫자의 나눗셈 연산이 잘 수행된다.")
  @Test
  void divideCorrectly() {
    int result = Calculator.calculate("4 / 2");
    assertThat(result).isEqualTo(2);
  }

  @DisplayName("여러 숫자의 복합적 사칙연산이 잘 수행된다.")
  @Test
  void complexCalculateCorrectly() {
    int result = Calculator.calculate("10 + 5 - 5 / 2");
    assertThat(result).isEqualTo(5);
  }

  @DisplayName("연산자 자리에 +,-,*,/ 이외의 값이 존재할 경우 예외를 발생한다.")
  @Test
  void operatorInvalid() {
    assertThatThrownBy(() -> {
      Calculator.calculate("3 + 3 # 2");
    }).isInstanceOf(IllegalArgumentException.class);
  }
}