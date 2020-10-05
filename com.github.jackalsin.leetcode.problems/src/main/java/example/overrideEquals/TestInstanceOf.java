package example.overrideEquals;

/**
 * @author jacka
 * @version 1.0 on 6/29/2019
 */
public final class TestInstanceOf {

  private static class Parent implements Interface {

  }

  private static final class Child extends Parent {
  }

  private interface Interface {

  }

  public static void main(final String[] args) {
    Child child = new Child();
    Parent parentTypeChild = new Child();

    System.out.println(child instanceof Interface); // true
    System.out.println(child instanceof Child); // true
    System.out.println(child instanceof Parent); // true

    System.out.println(parentTypeChild instanceof Interface); // true
    System.out.println(parentTypeChild instanceof Child); // true
    System.out.println(parentTypeChild instanceof Parent); // true
  }
}
