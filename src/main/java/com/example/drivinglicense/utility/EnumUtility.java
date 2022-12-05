package com.example.drivinglicense.utility;

public class EnumUtility {
	
	enum Type {
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
	
	enum Category {
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
}

