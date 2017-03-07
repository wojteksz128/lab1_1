package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
	
	private String Id;

	private BigDecimal price;

	private String name;

	private Date snapshotDate;

	private ProductType type;

	public Product(String id, BigDecimal price, String name, Date snapshotDate, ProductType type) {
		super();
		Id = id;
		this.price = price;
		this.name = name;
		this.snapshotDate = snapshotDate;
		this.type = type;
	}

	public String getId() {
		return Id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public Date getSnapshotDate() {
		return snapshotDate;
	}

	public ProductType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((snapshotDate == null) ? 0 : snapshotDate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Product other = (Product) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (snapshotDate == null) {
			if (other.snapshotDate != null)
				return false;
		} else if (!snapshotDate.equals(other.snapshotDate))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}
