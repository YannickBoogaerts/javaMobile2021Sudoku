package be.technifutur.sudoku;

public class Main {

    public static void main(String[] args) {
        System.out.println("Sudoku");
        TestSudoku4x4();
    }

    private static void TestSudoku4x4() {
        Sudoku4X4 sudoku4X4 = new Sudoku4X4();
        System.out.println(sudoku4X4.isCellValid(0,0)?"ok":"ko");
    }

}
