package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
	
	private String cause;

	private BigDecimal value;
	
	private String valueCurrency;

	public Discount(String cause, BigDecimal value, String valueCurrency) {
		super();
		this.cause = cause;
		this.value = value;
		this.valueCurrency = valueCurrency;
	}

	public String getCause() {
		return cause;
	}

	public BigDecimal getValue() {
		return value;
	}

	public String getValueCurrency() {
		return valueCurrency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cause == null) ? 0 : cause.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((valueCurrency == null) ? 0 : valueCurrency.hashCode());
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
		Discount other = (Discount) obj;
		if (cause == null) {
			if (other.cause != null)
				return false;
		} else if (!cause.equals(other.cause))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (valueCurrency == null) {
			if (other.valueCurrency != null)
				return false;
		} else if (!valueCurrency.equals(other.valueCurrency))
			return false;
		return true;
	}
	
	
}
