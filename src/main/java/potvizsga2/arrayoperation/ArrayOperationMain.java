package potvizsga2.arrayoperation;

public class ArrayOperationMain {

    public static void main(String[] args) {
        ArrayOperation arrayOperation = new ArrayOperation();

        System.out.println(arrayOperation.getWordsBackwards(new String[]{"alma", "körte", "barack"})); // barack, körte, alma
    }
}
