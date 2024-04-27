package umg.edu.progra.bst;

public class PasswordConfigDTO {
    private int minLength;

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public boolean isRestrictMinDigits() {
        return false;
    }

    public int getMinDigits(boolean b) {
        int i = 0;
        return i;
    }

    public boolean isRestrictMinUpperCaseLetters() {
        return false;
    }

    public int getMinUpperCaseLetters() {
        return 0;
    }

    public boolean isRestrictMinLowerCaseLetters() {
        return false;
    }

    public int getMinLowerCaseLetters() {
        return 0;
    }

    public boolean isRestrictMinNonAlphanumericCharacters() {
        return false;
    }

    public int getMinNonAlphanumericCharacters() {
        return 0;
    }

    public void setMinDigits(int i) {
    }

    public void setRestrictMinUpperCaseLetters(boolean b) {
    }

    public void setMinUpperCaseLetters(int i) {
    }

    public void setMinLowerCaseLetters(int i) {
    }

    public void setRestrictMinLowerCaseLetters(boolean b) {
    }

    public void setRestrictMinNonAlphanumericCharacters(boolean b) {
    }

    public void setMinNonAlphanumericCharacters(int i) {
    }
}
