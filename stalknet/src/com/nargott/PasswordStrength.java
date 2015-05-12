package com.nargott;

public enum PasswordStrength {
	HIGH  ("abcdefghijklmnopqrstuvwxyz-ABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789()*&?/\\!@#$%^:;{}[]`~'\".,-+=".toCharArray()),
    MEDIUM("abcdefghijklmnopqrstuvwxyz-ABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789".toCharArray()),
    LOW   ("abcdefghijklmnopqrstuvwxyz0123456789".toCharArray()),
    HASH("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray()),
    HEX("ABCDEF0123456789".toCharArray()),
    NUMBERS("0123456789".toCharArray())
    ; // semicolon needed when fields / methods follow


    private final char[] strength;

    PasswordStrength(char[] strength) {
        this.strength = strength;
    }
    
    public char[] getStrength() {
        return this.strength;
    }
}
