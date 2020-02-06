package interviews.hulu.xmlParser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 12/23/2019
 */
public final class XmlNode {
  private final Set<XmlNode> children = new LinkedHashSet<>();
  private final String value;
  private final String label;

  public XmlNode(final String label, final Collection<XmlNode> children) {
    this.label = label;
    this.value = null;
    this.children.addAll(children);
  }

  public XmlNode(final String label, final String value) {
    this.label = label;
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void addChild(final XmlNode node) {
    if (value != null) {
      throw new IllegalStateException("this node value is assigned = " + value);
    }
    children.add(node);
  }

  public List<XmlNode> getChildren() {
    return new ArrayList<>(children);
  }

  public String getLabel() {
    return label;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof XmlNode)) return false;
    XmlNode xmlNode = (XmlNode) o;
    return Objects.equals(children, xmlNode.children) &&
        Objects.equals(value, xmlNode.value) &&
        Objects.equals(label, xmlNode.label);
  }

  @Override
  public int hashCode() {
    return Objects.hash(children, value, label);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("<").append(label).append(">\n");
    if (children.isEmpty()) {
      sb.append(value).append("\n");
    } else {
      children.forEach(c -> sb.append(c));
    }
    sb.append("</").append(label).append(">\n");
    return sb.toString();
  }
}
