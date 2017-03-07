/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class OfferItem {

	// product
	private Product product;

	private int quantity;

	private String currency;

	private Discount discount;
	

	public OfferItem(Product product, int quantity) {
		this(product, quantity, new Discount(null, BigDecimal.ZERO, null));
	}

	public OfferItem(Product product, int quantity,
			Discount discount) {
		this.product = product;

		this.quantity = quantity;
		this.discount = discount;
	}

	public Product getProduct() {
		return product;
	}

	public BigDecimal getTotalCost() {
		BigDecimal discountValue = BigDecimal.ZERO;
		
		if (this.discount != null) {
			discountValue = this.discount.getValue();
		}
		
		return product.getPrice()
				.multiply(new BigDecimal(quantity)).subtract(discountValue);
	}

	public String getTotalCostCurrency() {
		return currency;
	}

	

	public int getQuantity() {
		return quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OfferItem other = (OfferItem) obj;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	/**
	 * 
	 * @param item
	 * @param delta
	 *            acceptable percentage difference
	 * @return
	 */
	public boolean sameAs(OfferItem other, double delta) {
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;

		if (quantity != other.quantity)
			return false;

		BigDecimal max, min;
		if (getTotalCost().compareTo(other.getTotalCost()) > 0) {
			max = getTotalCost();
			min = other.getTotalCost();
		} else {
			max = other.getTotalCost();
			min = getTotalCost();
		}

		BigDecimal difference = max.subtract(min);
		BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

		return acceptableDelta.compareTo(difference) > 0;
	}

}
