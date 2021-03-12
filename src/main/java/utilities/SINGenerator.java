package utilities;

import java.util.Random;

public class SINGenerator {

    private static final int[] MAP = {
            0,
            2,
            4,
            6,
            8,
            1 + 0,
            1 + 2,
            1 + 4,
            1 + 6,
            1 + 8
    };

    public static String generate() {

        final int firstDigit = new Random().nextInt(10);
        if (firstDigit == 8) {
            return generate(0);
        } else {
            return generate(firstDigit);
        }
    }

    public static String generate(final int firstDigit) {

        if (firstDigit < 0 || firstDigit > 9 || firstDigit == 8) {
            throw new IllegalArgumentException("Not a valid first digit for SIN: " + firstDigit);
        }
        int checksum = firstDigit;
        // Choose middle digits such that there are 7 digits, but the first digit may not be 0 or 9
        // the reason the first digit cannot be 9 is to ensure there's room for a carry when the checksum mod 10 is 0
        final int middleDigits = new Random().nextInt(9999999 + 1 - 1000000 - 1000000) + 1000000;
        final int[] digits = new int[]{
                middleDigits / 1000000 % 10,
                middleDigits / 100000 % 10,
                middleDigits / 10000 % 10,
                middleDigits / 1000 % 10,
                middleDigits / 100 % 10,
                middleDigits / 10 % 10,
                middleDigits % 10
        };
        for (int i = 0; i < 7; ++i) {
            if (i % 2 == 1) {
                checksum += digits[i];
            } else {
                checksum += MAP[digits[i]];
            }
        }
        while (checksum % 10 == 0) {
            checksum = checksum - MAP[digits[0]] - digits[1];
            digits[0] = (digits[1] + 1) / 10;
            digits[1] = (digits[1] + 1) % 10;
            checksum = checksum + MAP[digits[0]] + digits[1];
        }
        final int checkDigit = 10 - checksum % 10;
        return String.format("%d%d%d%05d%d", firstDigit, digits[0], digits[1], middleDigits % 100000, checkDigit);
    }

    public static int generateFirstDigit() {
        int firstDigit;
        do {
            firstDigit = new Random().nextInt(10);
            if (firstDigit != 0 && firstDigit != 8 && firstDigit != 9) {
                return firstDigit;
            }
        }
        while (true);
    }

    public static String generateSIN() {
        return generate(generateFirstDigit());
    }
//    public static void main(String[] args)
//    {
//        System.out.println("SIN:"+generate(generateFirstDigit()));
//    }}
}