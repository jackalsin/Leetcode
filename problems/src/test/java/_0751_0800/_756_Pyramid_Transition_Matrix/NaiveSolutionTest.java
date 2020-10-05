package _0751_0800._756_Pyramid_Transition_Matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/11/2019.
 */
class NaiveSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new NaiveSolution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final String bottom = "ABC";
    final List<String> allowed = List.of("ABD", "BCE", "DEF", "FFF");
    assertTrue(solution.pyramidTransition(bottom, allowed));
  }

  /**
   * This one check the G;
   */
  @Test
  void testOnlineCase2() throws Exception {
    final String bottom = "CBEFGAD";
    final List<String> allowed = List.of("AAE", "GBG", "AAF", "AAA", "ACF", "AAC", "BGA", "BCD",
        "BCE",
        "CDG", "AGB", "FEE", "BAB", "DEA", "CCG", "DEC", "EEG", "DGB", "BFA", "DAE", "DAF",
        "DGA", "CAF",
        "CEA", "FCD", "DFA", "DCD", "EAF", "GGE", "CEB", "FFD", "GEG", "DGG", "FCG", "BDG",
        "GAF", "FAG", "FAD",
        "FGC", "BFB", "ABB", "ABC", "ABD", "DEB", "CEF", "BBG", "BBF", "GGB", "BBB", "BBA",
        "BCA", "ADG", "ADD",
        "FAC", "GAB", "ADA", "EFD", "DDF", "DFC", "DDD", "CDE", "CDF", "EBG", "CDA", "CBD",
        "CDC", "CFF", "CFG",
        "CGC", "DBD", "DBF", "FBC", "FBB", "AEB", "DDG", "GAA", "GDF", "GDG", "GFB", "AEE",
        "ADE", "GFA", "FFC",
        "FGA");
    assertFalse(solution.pyramidTransition(bottom, allowed));
  }

  @Test
  void testOnlineCase3() throws Exception {
    final String bottom = "BGGDGEFC";
    final List<String> allowed = List.of(
        "BGE", "AGE", "AGD", "CCD", "CCG", "EGF", "EGE", "CCB", "DCF", "GBF", "DCE", "DCB",
        "DCC", "DCA",
        "FGD", "FGE", "FGF", "FGG", "FGB", "BFC", "BFA", "BFG", "BFF", "GAF", "GAD", "DBA",
        "FAF", "DBE",
        "DBG", "DBF", "FAD", "FFG", "FFF", "FFE", "FFA", "FDA", "GBE", "GBC", "FDG", "BEG",
        "BED", "BEE",
        "AEA", "ECA", "AEG", "AEF", "DEB", "DED", "DEF", "DEG", "CED", "CEA", "FBB", "CCC",
        "FBF", "BDE",
        "BDD", "GCC", "GCD", "GCG", "GCF", "AFF", "AFA", "AFB", "EFA", "EFB", "EFC", "DDF",
        "EFF", "DGG",
        "CBG", "ACB", "ACE", "ACD", "BCD", "BCF", "DDB", "DGB", "DGA", "ECB", "DGD", "DGE",
        "CGA", "CGB",
        "CGG", "CGF", "FCA", "GGF", "FCE", "FCF", "FCG", "EFG", "FEG", "FEB", "FEA", "BBF",
        "BBD", "BBC",
        "BBB", "ADB", "ADC", "DFE", "DFD", "DFF", "DFA", "DFB", "CDD", "CDE", "EDA", "EDG",
        "GDA", "FBA",
        "GDE", "AAE", "AAD", "AAF", "BAF", "BAG", "BAD", "BAB", "BAC", "CAC", "CAA", "CAG",
        "CAF", "CAE",
        "DAD", "DAF", "DAC", "EAA", "EEA", "EAD", "EAF", "FAB", "FAC", "GAE", "FAA", "GAC", "GAA", "FAE",
        "ABA", "ABB", "ABE", "ABF", "EFE", "EBA", "CFG", "CFA", "GFC", "GFA", "GFF");
    assertFalse(solution.pyramidTransition(bottom, allowed));
  }
}