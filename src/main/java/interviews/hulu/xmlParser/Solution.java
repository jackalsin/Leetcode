package interviews.hulu.xmlParser;

/**
 * @author jacka
 * @version 1.0 on 12/23/2019
 */
public interface Solution {
  /**
   * Glassdoor上见过这道题但是都没说清楚，刚听到题目就心态崩了，其实挺简单的，只是对XML不熟，理解题意二十分钟。题目已经将xml变
   * 成token了，每个token是{start, data, end}中的一种，将xml建成一个树。
   * 以下内容需要积分高于 110 您已经可以浏览
   * <p>
   * 解法是用Stack装TreeNode，每次遇见start的token就放个新的node进去，遇见data的Token就更新stack里的Node.data，
   * 遇见end的token就将stack里的node放到上一个node的subs里去。别想太复杂，xml是valid就很简单。
   *
   * @param tokens
   * @return
   */
  XmlNode parse(final String[] tokens);
}
