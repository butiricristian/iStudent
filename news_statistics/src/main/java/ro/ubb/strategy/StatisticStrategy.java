package ro.ubb.strategy;
import ro.ubb.dto.NewsDto;

import java.util.List;

public interface StatisticStrategy<T> {
   double calculateLikelyHood(NewsDto news, List<T> elements);
}
