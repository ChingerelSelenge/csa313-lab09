package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calculator = new ScholarshipCalculator();

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
        double[] scores = { 95, 85 };

        assertEquals(3.5, calculator.gpa(scores));
    }

    // A5: 100 хувийн тэтгэлэг шалгах
    @Test
    void scholarship_100Percent() {
        assertEquals(100, calculator.scholarship(3.9, 16, false));
    }

    // B1: Оноо 0-ээс бага үед exception
    @Test
    void letterGrade_NegativeScore() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.letterGrade(-1));
    }

    // B2: Оноо 100-аас их үед exception
    @Test
    void letterGrade_Above100() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.letterGrade(101));
    }

    // B3: D үнэлгээ
    @Test
    void letterGrade_D() {
        assertEquals("D", calculator.letterGrade(65));
    }

    // B4: F үнэлгээ
    @Test
    void letterGrade_F() {
        assertEquals("F", calculator.letterGrade(55));
    }

    // B5: GPA null массив
    @Test
    void gpa_NullScores() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(null));
    }

    // B6: GPA хоосон массив
    @Test
    void gpa_EmptyScores() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(new double[] {}));
    }

    // B7: Scholarship GPA 0-ээс бага
    @Test
    void scholarship_NegativeGpa() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(-1, 15, false));
    }

    // B8: Scholarship GPA 4-өөс их
    @Test
    void scholarship_GpaAbove4() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(4.1, 15, false));
    }

    // B9: Scholarship кредит 0-ээс бага
    @Test
    void scholarship_NegativeCredits() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(3.5, -1, false));
    }

    // B10: Сахилгын зөрчилтэй бол тэтгэлэг 0
    @Test
    void scholarship_HasViolation() {
        assertEquals(0, calculator.scholarship(4.0, 20, true));
    }

    // B11: 70 хувийн тэтгэлэг
    @Test
    void scholarship_70Percent() {
        assertEquals(70, calculator.scholarship(3.5, 12, false));
    }

    // B12: 50 хувийн тэтгэлэг
    @Test
    void scholarship_50Percent() {
        assertEquals(50, calculator.scholarship(3.2, 10, false));
    }

    // B13: Голч хүрэхгүй бол 0 хувийн тэтгэлэг
    @Test
    void scholarship_ZeroPercent() {
        assertEquals(0, calculator.scholarship(2.9, 20, false));
    }

    // B14: GPA 3.8 хүрсэн боловч кредит 15 хүрээгүй
    @Test
    void scholarship_HighGpaInsufficientCredits() {
        assertEquals(70, calculator.scholarship(3.9, 14, false));
    }

    // B15: GPA 3.4 хүрсэн боловч кредит 12 хүрээгүй
    @Test
    void scholarship_MidGpaInsufficientCredits() {
        assertEquals(50, calculator.scholarship(3.5, 11, false));
    }

    // B16: GPA тооцоололд D болон F үнэлгээ ашиглах
    @Test
    void gpa_IncludesDAndFGrades() {
        double[] scores = { 65, 55 };

        assertEquals(0.5, calculator.gpa(scores));
    }

    // B17: GPA тооцоололд C үнэлгээ ашиглах
    @Test
    void gpa_IncludesCGrade() {
        double[] scores = { 75 };

        assertEquals(2.0, calculator.gpa(scores));
    }

    // C1: 0 элементтэй массив
    @Test
    void gpa_ZeroIterations() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(new double[] {}));
    }

    // C2: null массив
    @Test
    void gpa_NullArray() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(null));
    }

    // C3: 1 элементтэй массив
    @Test
    void gpa_OneIteration() {
        double[] scores = { 95 };

        assertEquals(4.0, calculator.gpa(scores));
    }

    // C4: 2-оос олон элементтэй массив
    @Test
    void gpa_MultipleIterations() {
        double[] scores = { 95, 85, 75, 65 };

        assertEquals(2.5, calculator.gpa(scores));
    }
}