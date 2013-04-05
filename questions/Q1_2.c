/**
 * implement a function void reverse(char* str) in c or c++
 * which reverse a null-terminated string.
 */

#include <stdio.h>

void reverse(char *str) {
    char* end = str;
    char tmp;
    if (str) {
        while (*end) {
            ++end;
        }
        --end;

        while (str < end) {
            tmp = *str;
            *str++ = *end;
            *end-- = tmp;
        }
    }
}

void main() {
    char str[10] = "abcdefg\0";
    reverse(str);
    printf("%s",str);
}
