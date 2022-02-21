public class MyException extends Throwable {
    public MyException(String s) {
        System.out.println("//т.к. строка не является математической операцией");
    }
}
