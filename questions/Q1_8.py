#!/usr/bin/env python

# assume you have method isSubstring which checks if one word is a substring of a another.
# given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only
# one call to isSubstring (e.g., "waterbottle" is a rotation of "erbottlewat")

def isSubstring(s1, s2):
    """check if s1 is substring of s2"""
    return s1 in s2

def isRotation(s1, s2):
    """check if s1 is the rotation of s2"""
    tmp = s1+s1
    return s2 in tmp


if __name__ == '__main__':
    s1 = "waterbottle"
    s2 = "erbottlewat"

    print isRotation(s2, s1)
