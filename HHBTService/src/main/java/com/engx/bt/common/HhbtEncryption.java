package com.engx.bt.common;

import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;

public class HhbtEncryption {
    /**
     * This method used for decrypt the String.
     *
     * @param encryptKey
     *            encryptKey
     * @param salt
     *            salt
     * @return decrypted data
     */
    public static String
            decrypt(final String encryptKey, final String salt) {
        String result = null;
        if (encryptKey.length() > TWELVE) {
            result =
                    new String(Base64.decodeBase64(encryptKey)).replace(
                            salt, "");
        }
        return result;
    }

    /**
     * This method used for encrypt the String.
     *
     * @param input
     *            input
     * @param salt
     *            salt
     * @return encrypted data
     */
    public static String encrypt(final String input, final String salt) {
        return new String(Base64.encodeBase64((input + salt).getBytes()));
    }

    /**
     * magic number.
     */
    private static final int FOURTYNINE = 0x49;
    /**
     * magic number.
     */
    private static final int SEVENTYSIX = 0x76;
    /**
     * magic number.
     */
    private static final int SIXTYONE = 0x61;
    /**
     * magic number.
     */
    private static final int SIX_E = 0x6e;
    /**
     * magic number.
     */
    private static final int TWENTY = 0x20;
    /**
     * magic number.
     */
    private static final int FOUR_D = 0x4d;
    /**
     * magic number.
     */
    private static final int SIXTYFIVE = 0x65;
    /**
     * magic number.
     */
    private static final int SIXTYFOUR = 0x64;

    /**
     * Magic Number.
     */
    private static final int TWELVE = 12;

    /**
     * dafault salt.
     */
    private static byte[] dafultsalt = { (byte) FOURTYNINE,
            (byte) SEVENTYSIX, (byte) SIXTYONE, (byte) SIX_E,
            (byte) TWENTY, (byte) FOUR_D, (byte) SIXTYFIVE,
            (byte) SIXTYFOUR, (byte) SEVENTYSIX, (byte) SIXTYFIVE,
            (byte) SIXTYFOUR, (byte) SIXTYFIVE, (byte) SEVENTYSIX };

    /**
     * This method is used to prepare salt. salt is a random string of data
     * used to modify a data hash.
     *
     * @return salt String
     */
    public String getSalt() {
        final byte[] salt = dafultsalt;
        return Arrays.toString(salt);
    }

}