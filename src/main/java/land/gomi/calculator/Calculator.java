package land.gomi.calculator;

import org.springframework.stereotype.Service;

/**
 * This is a simple Calculator class
 */
@Service
public class Calculator {
    int sum(int a, int b) {
        return a + b;
    }

    int sub(int a, int b) {
        return a - b;
    }
}
