import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class PasswordCreator {

    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String PUNCTUATION = "!@#$%&*()_+-=[]|,./?><";
    private static final String DIGITS = "0123456789";
    private boolean canLower;
    private boolean canUpper;
    private boolean canDigits;
    private boolean canPunctuation;

    //Constructor
    private PasswordCreator(PasswordGenerator passwordgenerator) {
        this.canUpper = passwordgenerator.canUpper;
        this.canLower = passwordgenerator.canLower;
        this.canDigits = passwordgenerator.canDigits;
        this.canPunctuation = passwordgenerator.canPunctuation;
    }

    /* PasswordGenerator starts.*/
    public static class PasswordGenerator {
        private boolean canLower;
        private boolean canUpper;
        private boolean canDigits;
        private boolean canPunctuation;

        public PasswordGenerator() {
            this.canLower = false;
            this.canUpper = false;
            this.canDigits = false;
            this.canPunctuation = false;
        }

        /* If you want to use lower character it should be true. False is default.*/
        public PasswordGenerator canLower(boolean canLower) {
            this.canLower = canLower;
            return this;
        }

        /* If you want to use digits it should be true. False is default.*/
        public PasswordGenerator canDigits(boolean canDigits) {
            this.canDigits = canDigits;
            return this;
        }

        /* If you want to use upper characters it should be true. False is default.*/
        public PasswordGenerator canUpper(boolean canUpper) {
            this.canUpper = canUpper;
            return this;
        }

        /* If you want to use punctuation characters it should be true. False is default.*/
        public PasswordGenerator canPunctuation(boolean canPunctuation) {
            this.canPunctuation = canPunctuation;
            return this;
        }

        /* Get PasswordCreator object.*/
        public PasswordCreator init() {
            return new PasswordCreator(this);
        }

    }
    /* PasswordGenerator ends.*/

    /* Select properties for password.*/
    public String createPassword(int length){

        /* if password length < 0 return empty password string*/
        if(length <= 0 ) {
            return "";
        }

        /* Password variable*/
        StringBuilder pw = new StringBuilder(length);
        Random r = new Random();

        /* Password properties are collecting*/
        List<String> properties = new ArrayList<>(4);
        if (canLower) {
            properties.add(LOWER);
        }
        if (canUpper) {
            properties.add(UPPER);
        }
        if (canDigits) {
            properties.add(DIGITS);
        }
        if (canPunctuation) {
            properties.add(PUNCTUATION);
        }

        /*Create the password*/
        for(int i = 0; i<length;i++) {

            /* Get random char type*/
            String randomChar = properties.get(r.nextInt(properties.size()));

            /* Get char type's random index between(0-randomChar.length -> inclusive - exclusive)*/
            int position = r.nextInt(randomChar.length());

            /* Set random char to password. */
            pw.append(randomChar.charAt(position));
        }
        /* Return password.*/
        return new String(pw);
    }

}
