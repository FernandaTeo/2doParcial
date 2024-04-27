

//Ejercicio 2 Segunda Parte Parcial

package umg.edu.progra.bst; // Declaración del paquete donde se encuentra la clase

import java.security.SecureRandom;
import java.util.Random;

public class PasswordGenerator {

    // Definición de constantes para los conjuntos de caracteres posibles en la contraseña
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+";

    // Conjunto de todos los caracteres posibles
    private static final String ALL_CHARS = LOWERCASE_CHARS + UPPERCASE_CHARS + DIGITS + SPECIAL_CHARS;

    // Objeto Random seguro para la generación aleatoria de contraseñas
    private static final Random RANDOM = new SecureRandom();

    // Método estático para generar una contraseña basada en la configuración proporcionada
    public static String generatePassword(PasswordConfigDTO config) {
        if (config == null) {
            throw new IllegalArgumentException("El objeto de configuración no puede ser nulo.");
        }

        // Obtener configuración de la contraseña desde el objeto PasswordConfigDTO
        int minLength = config.getMinLength();
        boolean restrictMinDigits = config.isRestrictMinDigits();
        int minDigits = config.getMinDigits(true); // Esto no parece necesario
        boolean restrictMinUpperCaseLetters = config.isRestrictMinUpperCaseLetters();
        int minUpperCaseLetters = config.getMinUpperCaseLetters();
        boolean restrictMinLowerCaseLetters = config.isRestrictMinLowerCaseLetters();
        int minLowerCaseLetters = config.getMinLowerCaseLetters();
        boolean restrictMinNonAlphanumericCharacters = config.isRestrictMinNonAlphanumericCharacters();
        int minNonAlphanumericCharacters = config.getMinNonAlphanumericCharacters();

        // StringBuilder para construir la contraseña
        StringBuilder password = new StringBuilder(minLength);

        // Validaciones
        if (!restrictMinDigits) {
            // Si no hay restricción de dígitos mínimos, se garantiza al menos un dígito
            minLength = Math.max(minLength, 8); // Cumple con los requisitos de la Versión 1
            minDigits = 1;
        }

        if (minLength < 8) {
            // La longitud mínima de la contraseña debe ser al menos 8 caracteres
            throw new IllegalArgumentException("La longitud mínima de la contraseña debe ser al menos 8 caracteres.");
        }

        if (minDigits > minLength || minUpperCaseLetters > minLength || minLowerCaseLetters > minLength || minNonAlphanumericCharacters > minLength) {
            // Las cantidades mínimas no pueden ser mayores que la longitud mínima de la contraseña
            throw new IllegalArgumentException("Las cantidades mínimas no pueden ser mayores que la longitud mínima de la contraseña.");
        }

        // Agregar caracteres obligatorios a la contraseña
        password.append(getRandomChar(LOWERCASE_CHARS));
        password.append(getRandomChar(UPPERCASE_CHARS));
        password.append(getRandomChar(DIGITS));
        password.append(getRandomChar(SPECIAL_CHARS));

        // Agregar caracteres adicionales para cumplir con las cantidades mínimas requeridas
        password.append(generateRandomChars(LOWERCASE_CHARS, minLowerCaseLetters));
        password.append(generateRandomChars(UPPERCASE_CHARS, minUpperCaseLetters));
        password.append(generateRandomChars(DIGITS, minDigits));
        password.append(generateRandomChars(SPECIAL_CHARS, minNonAlphanumericCharacters));

        // Mezclar la contraseña para mayor seguridad
        shufflePassword(password);

        return password.toString();
    }

    // Método para obtener un carácter aleatorio de un conjunto de caracteres
    private static char getRandomChar(String charSet) {
        int randomIndex = RANDOM.nextInt(charSet.length());
        return charSet.charAt(randomIndex);
    }

    // Método para generar una cadena de caracteres aleatorios de un conjunto de caracteres
    private static String generateRandomChars(String charSet, int count) {
        StringBuilder randomChars = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            randomChars.append(getRandomChar(charSet));
        }
        return randomChars.toString();
    }

    // Método para mezclar los caracteres de la contraseña para mayor seguridad
    private static void shufflePassword(StringBuilder password) {
        for (int i = password.length() - 1; i > 0; i--) {
            int randomIndex = RANDOM.nextInt(i + 1);
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(randomIndex));
            password.setCharAt(randomIndex, temp);
        }
    }

    // Método main para probar la generación de contraseña con un objeto de configuración
    public static void main(String[] args) {
        // Ejemplo de uso con un objeto de configuración
        PasswordConfigDTO config = new PasswordConfigDTO();
        config.setMinLength(12);
        config.getMinDigits(true); // Esto no parece necesario
        config.setMinDigits(2);
        config.setRestrictMinUpperCaseLetters(false);
        config.setMinUpperCaseLetters(1);
        config.setRestrictMinLowerCaseLetters(false);
        config.setMinLowerCaseLetters(1);
        config.setRestrictMinNonAlphanumericCharacters(true);
        config.setMinNonAlphanumericCharacters(2);

        // Generar contraseña utilizando la configuración proporcionada
        String password = PasswordGenerator.generatePassword(config);

        // Imprimir la contraseña generada
        System.out.println("Contraseña generada: " + password);
    }
}
