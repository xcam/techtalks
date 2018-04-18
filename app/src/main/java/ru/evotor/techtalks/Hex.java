package ru.evotor.techtalks;

public class Hex {

    private static final String HEX_FORMAT = "%02X";

    public static String toHexString(final byte b) {
        return String.format(HEX_FORMAT, b);
    }

    public static String toHexString(final byte[] data) {
        return toHexString(data, 0, data.length);
    }

    public static String toHexString(final byte[] data, int start, int stop) {
        StringBuilder builder = new StringBuilder();
        for (int i = start; i < stop; i++) {
            builder.append(toHexString(data[i]));
        }
        return builder.toString();
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}
