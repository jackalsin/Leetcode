package _0501_0550._537_Complex_Number_Multiplication;

/**
 * @author jacka
 * @version 1.0 on 1/26/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String complexNumberMultiply(String a, String b) {
    final Complex aComp = new Complex(a), bComp = new Complex(b);
    final int real = aComp.real * bComp.real - aComp.virtual * bComp.virtual,
        virtual = aComp.virtual * bComp.real + aComp.real * bComp.virtual;
    return new StringBuilder().append(real).append("+").append(virtual).append("i").toString();
  }

  private static final class Complex {
    private final int real, virtual;

    private Complex(int real, int virtual) {
      this.real = real;
      this.virtual = virtual;
    }

    private Complex(final String str) {
      final String[] items = str.split("\\+");
      this.real = Integer.parseInt(items[0]);
      this.virtual = Integer.parseInt(items[1].substring(0, items[1].length() - 1));
    }

    @Override
    public String toString() {
      return String.format("%d+%di", real, virtual);
    }
  }
}
