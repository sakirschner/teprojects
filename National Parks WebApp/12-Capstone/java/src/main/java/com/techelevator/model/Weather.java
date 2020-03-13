package com.techelevator.model;

public class Weather {

	private String code;
	private int forecastValue;
	private double low;
	private double high;
	private String forecast;
	private boolean isF = true; 
	private String image;
	private String responseForecast;
	private String responseTemp;
	
	public String getResponseForecast() {
		responseForecast = "";
		if (forecast.equals("snow")) {
			responseForecast = "Pack snowshoes!";
		}
		if (forecast.equals("rain")) {
			responseForecast = "Pack rain gear and wear waterproof shoes!";
		}
		if (forecast.equals("thunderstorms")) {
			responseForecast = "Seek shelter and avoid hiking on exposed ridges!";
		}
		if (forecast.equals("sunny")) {
			responseForecast = "Pack sunblock!";
		}
		return responseForecast;
	}

	public void setResponseForecast(String responseForecast) {
		this.responseForecast = responseForecast;
	}

	public String getImage() {
		image = forecast.replace(" ", "");
		if (image.equals("partlycloudy")) {
			image = "partlyCloudy";
		}
		return image;
	}

	public String getResponseTemp() {
		responseTemp = "";
		if (isF == true) {
		if (high > 75) {
			responseTemp = "Bring an extra gallon of water!";
		}
		if ((high-low) >= 20) {
			responseTemp = "Wear breathable layers!";
		}
		if (low < 20) {
			responseTemp = "Wear warm clothing...you will be exposed to frigid tempertures!";
		}
		}
		if (isF == false) {
			if (high > 23.8) {
				responseTemp = "Bring an extra gallon of water!";
			}
			if ((high-low) >= 6.6) {
				responseTemp = "Wear breathable layers!";
			}
			if (low < -6.6) {
				responseTemp = "Wear warm clothing...you will be exposed to frigid tempertures!";
			}
			}
		return responseTemp;
	}

	public void setResponseTemp(String responseTemp) {
		this.responseTemp = responseTemp;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isF() {
		return isF;
	}

	public void setF(boolean isF) {
		this.isF = isF;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getForecastValue() {
		return forecastValue;
	}

	public void setForecastValue(int forecastValue) {
		this.forecastValue = forecastValue;
	}

	public double getLow() {
		if (isF == false) {
			low = (low - 32) * (5.0/9.0);
		}
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getHigh() {
		if (isF == false) {
			this.high = ((this.high - 32) * (5.0/9.0));
		} 
		return this.high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

}
