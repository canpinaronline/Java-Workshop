import java.security.SecureRandom;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        PasswordCreator passwordcreator = new PasswordCreator.PasswordGenerator()
                .canLower(true)
                .canDigits(true)
                .canUpper(true)
                .canPunctuation(true)
                .init();
        String password = passwordcreator.createPassword(25);
        System.out.println(password);




    }


}