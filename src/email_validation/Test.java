package email_validation;

public class Test {
    public static void main(String[] args) {
        String email1 = "serega@gmail.com";
        String email2 = "1sereg44a@gmail.com";
        String email3 = "sere13ga@gmail.c";
        String email4 = "sere_ga@gmail";
        System.out.println(EmailValidator.validate(email1));
        System.out.println(EmailValidator.validate(email2));
        System.out.println(EmailValidator.validate(email3));
        System.out.println(EmailValidator.validate(email4));
    }

}
