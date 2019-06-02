package com.food.platform.v2;

import java.math.BigDecimal;

public interface Buyer {
	
	BigDecimal calPrice(BigDecimal orderPrice);
}