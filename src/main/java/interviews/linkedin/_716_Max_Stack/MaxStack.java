package interviews.linkedin._716_Max_Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface MaxStack {

  void push(int x);

  int pop();

  int top();

  int peekMax();

  int popMax();
}

