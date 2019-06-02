package com.food.platform;

import java.math.BigDecimal;

public class Test1 {
	
	public static void main(String[] args) {
		BigDecimal resultPrice = calPrice(new BigDecimal("100"), "1");
		System.err.println(resultPrice);
	}
	
	/**
	 * 以后增加了一个新需求，就要改动函数代码，还要考虑优先级问题，不符合开闭原则
	 * 
	 * @param orderPrice
	 * @param _buyerType
	 * @return
	 */
	public static BigDecimal calPrice(BigDecimal orderPrice,String _buyerType){
		BigDecimal resultPrice = orderPrice;
		if(BuyerType.SUPER_VIP.name().equals(_buyerType)){
			resultPrice = resultPrice.multiply(new BigDecimal("0.8"));
		}else if(BuyerType.VIP.name().equals(_buyerType)){
			resultPrice = resultPrice.multiply(new BigDecimal("0.9"));
		}
		return resultPrice;
	}
}