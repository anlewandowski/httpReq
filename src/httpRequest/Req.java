package httpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Req {

	public static void main(String[] args) throws IOException{
		String s = sendGET();
		Gson gson = new GsonBuilder().create();
		JSONObjects obj = gson.fromJson(s, JSONObjects.class);
		System.out.println(obj); // A273406 A274059
	}
	
	/**
	 * This method gets input from the user. The user needs to enter country
	 * code and product number for the method to send GET request to the api.
	 * 
	 * @return json response about the product
	 * @throws IOException
	 */
	private static String sendGET() throws IOException {
		/* getting user input */
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter your country from uk, de, us, it, fr, jp: \n");
		String country = scan.nextLine();
		System.out.print("Please enter the product #: \n");
		String product = scan.nextLine();
		scan.close();

		/* putting the user input in the api */
		String GET_URL = "https://api.qvc.com/api/sales/presentation/v3/" + country + "/products/" + product
				+ "?response-depth=full";

		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		/* send in GET request */
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();

		/* HTTP_OK = 200 */
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			/* store the response in the variable name response */
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			/* return json response */
			return response.toString();
		} else if (responseCode == HttpURLConnection.HTTP_BAD_REQUEST) {
			System.out.println("Product unavailable");
			return "Product unavailable";
		} else {
			System.out.println("GET Response Code :: " + responseCode);
			return "GET request not worked";
		}

	}

}
