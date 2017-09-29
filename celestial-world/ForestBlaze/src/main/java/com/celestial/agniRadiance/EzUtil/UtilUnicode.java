package com.celestial.agniRadiance.EzUtil;

public class UtilUnicode
{
  public static String decodeUnicode(String unicodeStr)
  {
    int len = unicodeStr.length();

    StringBuffer outBuffer = new StringBuffer(len);

    for (int x = 0; x < len; ) {
      char aChar = unicodeStr.charAt(x++);
      if (aChar == '\\') {
        aChar = unicodeStr.charAt(x++);
        if (aChar == 'u') {
          StringBuffer buffer = new StringBuffer();
          boolean ch = true;
          buffer.append("\\u");
          int value = 0;
          if (len - x >= 4)
            for (int i = 0; i < 4; i++) {
              aChar = unicodeStr.charAt(x++);
              buffer.append(aChar);
              switch (aChar) {
              case '0':
              case '1':
              case '2':
              case '3':
              case '4':
              case '5':
              case '6':
              case '7':
              case '8':
              case '9':
                value = (value << 4) + aChar - 48;
                break;
              case 'a':
              case 'b':
              case 'c':
              case 'd':
              case 'e':
              case 'f':
                value = (value << 4) + 10 + aChar - 97;
                break;
              case 'A':
              case 'B':
              case 'C':
              case 'D':
              case 'E':
              case 'F':
                value = (value << 4) + 10 + aChar - 65;
                break;
              case ':':
              case ';':
              case '<':
              case '=':
              case '>':
              case '?':
              case '@':
              case 'G':
              case 'H':
              case 'I':
              case 'J':
              case 'K':
              case 'L':
              case 'M':
              case 'N':
              case 'O':
              case 'P':
              case 'Q':
              case 'R':
              case 'S':
              case 'T':
              case 'U':
              case 'V':
              case 'W':
              case 'X':
              case 'Y':
              case 'Z':
              case '[':
              case '\\':
              case ']':
              case '^':
              case '_':
              case '`':
              default:
                ch = false;
              }
            }
          else {
            ch = false;
          }
          if (ch)
            outBuffer.append((char)value);
          else
            outBuffer.append(buffer);
        }
        else {
          if (aChar == 't')
            aChar = '\t';
          else if (aChar == 'r')
            aChar = '\r';
          else if (aChar == 'n')
            aChar = '\n';
          else if (aChar == 'f')
            aChar = '\f';
          outBuffer.append(aChar);
        }
      } else {
        outBuffer.append(aChar);
      }
    }
    return outBuffer.toString();
  }
}