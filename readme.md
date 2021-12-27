# 1: Create a database in mysql name "etisalat_task_db"

# To clone project from github follow the below steps
*1. open command prompt in some directory
*2. type git clone https://github.com/wajidali123/WeatherApplication.git 
*3. import project into eclipse
*4. open application.properties file and add the db name, username and password
*4. run the project (mvn spring-boot:run)


# API list
*1. By Default one user will be create with username and password as 'admin'
*2. Open postman and import this collection 
	https://www.getpostman.com/collections/5ec27cda678db8bca6b6
*3. Swagger url: http://localhost:8080/swagger-ui.html
*4 Swagger documentation url : http://localhost:8080/v2/api-docs

# User regiseration:
	*Endpoint url: http://localhost:8080/api/v1/user/register
	*Http Method: POST
	*Authentication Mechanism: Basic Authentication
	*Request Body:
	{
		"name": "",
		"email": "",
		"password": ""
	}
	
	*Response:
	{
		"statusCode": 200,
		"respMessage": "Success",
		"response": {
			"name": "Wajid"
		}
	}
	
# Get weather details by cityname and country code
	**Endpoint url: http://localhost:8080/api/v1/forcast/weather?city=Islamabad&countryCode=PK
	**Http Method: GET
	**Authentication Mechanism: Basic Authentication (username = admin, password = admin)
	**Request Body: NA
	**query parameter: city, countryCode
	
	**Response:
	{
		"statusCode": 200,
		"respMessage": "Success",
		"response": {
			"coord": {
				"lon": 73.1338,
				"lat": 33.7104
			},
			"weather": [
				{
					"id": 800,
					"main": "Clear",
					"description": "clear sky",
					"icon": "01n"
				}
			],
			"base": "stations",
			"main": {
				"temp": 281.95,
				"feels_like": 280.93,
				"temp_min": 281.95,
				"temp_max": 281.95,
				"pressure": 1023,
				"humidity": 86,
				"sea_level": 1023,
				"grnd_level": 960
			},
			"visibility": 10000,
			"wind": {
				"speed": 2.02,
				"deg": 7.0,
				"gust": 2.06
			},
			"rain": null,
			"cloud": null,
			"dt": 1640625860,
			"sys": {
				"type": 2,
				"id": 2007435,
				"country": "PK",
				"sunrise": 1640571043,
				"sunset": 1640606760
			},
			"timezone": 18000,
			"id": 1162015,
			"name": "Islamabad",
			"cod": "200"
		}
	}
	
	
# Get weather details by latitude and longitude
	**Endpoint url: http://localhost:8080/api/v1/forcast/weather/coordinate?latitude=33.7104&longitude=73.1338
	**Http Method: GET
	**Authentication Mechanism: Basic Authentication (username = admin, password = admin)
	**Request Body: NA
	**query parameter: latitude, longitude
	**Response:
	{
		"statusCode": 200,
		"respMessage": "Success",
		"response": {
			"coord": {
				"lon": 73.1338,
				"lat": 33.7104
			},
			"weather": [
				{
					"id": 800,
					"main": "Clear",
					"description": "clear sky",
					"icon": "01n"
				}
			],
			"base": "stations",
			"main": {
				"temp": 281.95,
				"feels_like": 280.9,
				"temp_min": 281.95,
				"temp_max": 281.95,
				"pressure": 1023,
				"humidity": 86,
				"sea_level": 1023,
				"grnd_level": 960
			},
			"visibility": 10000,
			"wind": {
				"speed": 2.05,
				"deg": 10.0,
				"gust": 2.15
			},
			"rain": null,
			"cloud": null,
			"dt": 1640626536,
			"sys": {
				"type": 2,
				"id": 2007435,
				"country": "PK",
				"sunrise": 1640571043,
				"sunset": 1640606760
			},
			"timezone": 18000,
			"id": 1162015,
			"name": "Islamabad",
			"cod": "200"
		}
	}