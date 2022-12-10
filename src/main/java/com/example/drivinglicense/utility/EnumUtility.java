package com.example.drivinglicense.utility;

import org.springframework.stereotype.Component;

@Component
public class EnumUtility {
	
	public enum Type {
		CAR("CA"),
		BIKE("BI"),
		CARBIKE("CB"),
		HEAVY("HV");
		
		private String type;
		
		private Type(String type){
			this.type = type;
		}
		
		public String getType() {
			return type;
		}
	}
	
	public enum Category {
		PRIVATE("PV"),
		PUBLIC("PB"),
		TRANSPORT("TR"),
		GOVERNMENT("GV");
		
		private String category;
		
		private Category(String category){
			this.category = category;
		}
		
		public String getCategory() {
			return category;
		}
	}
	
	public enum Status {
		SUBMITTED("Submitted"),
		UNDERREVIEW("Under review"),
		APPROVED("Approved"),
		DISPATCHED("Dispatched"),
		DELIVERED("Delivered");
		
		private String status;
		
		private Status(String status) {
			this.status = status;
		}
		
		public String getStatus() {
			return status;
		}
	}
}

