package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calculator =
            new ScholarshipCalculator();

    // A1: A үнэлгээ шалгах
    @Test
    void letterGrade_A() {
        assertEquals("A", calculator.letterGrade(95));
    }

    // A2: B үнэлгээ шалгах
    @Test
    void letterGrade_B() {
        assertEquals("B", calculator.letterGrade(85));
    }

    // A3: C үнэлгээ шалгах
    @Test
    void letterGrade_C() {
        assertEquals("C", calculator.letterGrade(75));
    }

    // A4: Хэд хэдэн дүнгийн голч бодох
    @Test
    void gpa_NormalScores() {
        double[] scores = {95, 85};

        assertEquals(3.5, calculator.gpa(scores));
    }

    // A5: 100 хувийн тэтгэлэг шалгах
    @Test
    void scholarship_100Percent() {
        assertEquals(100, calculator.scholarship(3.9, 16, false));
    }
}