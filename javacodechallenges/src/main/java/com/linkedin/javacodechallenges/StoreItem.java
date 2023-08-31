package com.linkedin.javacodechallenges;

import java.util.Collection;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StoreItem {
  String name;
  double retailPrice;
  double discount;

  public static Optional<StoreItem> findLeastExpensive(Collection<StoreItem> items) {
    Optional<StoreItem> cheapestItem = Optional.empty();
    double cheapestPrice = Double.MAX_VALUE;

    for (StoreItem item : items) {
      double price = item.getRetailPrice() - (item.getRetailPrice() * item.getDiscount());
      if (price < cheapestPrice) {
        cheapestItem = Optional.of(item);
        cheapestPrice = price;
      }
    }
    return cheapestItem;
  }

  @Override
  public String toString() {
    return "Name: " + name + ", " + "Retail price: " + retailPrice + ", " + "Discount " + discount;
  }
}