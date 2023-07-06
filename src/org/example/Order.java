package org.example;


 class Order {
	 
	private int orderId;
	private String productName;
	private String consumerName;
	private int price;
	private int stock;
	
	 public Order(OrderBuilder builder) {
	        this.orderId = builder.orderId;
	        this.productName = builder.productName;
	        this.consumerName = builder.consumerName;
	        this.price = builder.price;
	        this.stock = builder.stock;
	    }
	
	 public static class OrderBuilder {
			private int orderId;
			private String productName;
			private String consumerName;
			private int price;
			private int stock;
		
			public OrderBuilder orderId(int orderId) {
				this.orderId = orderId;
				return this;
		}
		
		public OrderBuilder productName(String productName) {
			this.productName = productName;
			return this;
		}
		
		public OrderBuilder consumerName(String consumerName) {
			this.consumerName = consumerName;
			return this;
		}
		
		public OrderBuilder price(int price) {
			this.price = price;
			return this;
		}
		public OrderBuilder stock(int stock) {
			this.stock = stock;
			return this;
		}
		
		public Order build() {
			return new Order(this);
		}
	}


	public void showOrderInfo() {
		System.out.println("주문번호 : " + orderId);
		System.out.println("상품명 : " + productName);
		System.out.println("구매자 : " + consumerName);
		System.out.println("가격 : " + price);
		System.out.println("수량 : " + stock);
	}
	
	
}

