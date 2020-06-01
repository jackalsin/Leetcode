package _1451_1500._1452_People_Whose_List_of_Favorite_Companies_Is_Not_a_Subset_of_Another_List;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SolutionI implements Solution {
  @Override
  public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
    final Map<String, BitSet> companyFavoriteByPersonIds = getCompanyFavoriteByPersonIds(favoriteCompanies);
    System.out.println(companyFavoriteByPersonIds);
    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < favoriteCompanies.size(); ++i) {
      final List<String> curFavorite = favoriteCompanies.get(i);
      // there is no copy constructor
      final BitSet intersected = new BitSet();
      intersected.or(companyFavoriteByPersonIds.get(curFavorite.get(0)));
      for (int j = 1; j < curFavorite.size(); ++j) {
        final String company = curFavorite.get(j);
        final BitSet sameOwners = companyFavoriteByPersonIds.get(company);
        intersected.and(sameOwners);
      } // end of j
      if (intersected.cardinality() <= 1) result.add(i);
    }
    return result;
  }

  private static Map<String, BitSet> getCompanyFavoriteByPersonIds(final List<List<String>> favoriteCompanies) {
    final Map<String, BitSet> companyToPeopleId = new HashMap<>();
    for (int i = 0; i < favoriteCompanies.size(); ++i) {
      for (final String company : favoriteCompanies.get(i)) {
        companyToPeopleId.computeIfAbsent(company, k -> new BitSet()).set(i);
      }
    }
    return companyToPeopleId;
  }
}
