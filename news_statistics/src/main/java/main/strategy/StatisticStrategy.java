package main.strategy;
import main.dto.NewsDto;

import java.util.List;

public interface StatisticStrategy<T> {
   double calculateLikelyHood(NewsDto news, List<T> elements);
}
