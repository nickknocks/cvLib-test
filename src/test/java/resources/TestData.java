package resources;

import org.json.JSONException;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.commons.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

public class TestData {

	JSONObject testData;

	// CONSTRUCTOR:
	TestData(String brandName, String scriptName) {
		try {
			File file = new File("Info\\" + brandName + "\\json\\" + scriptName + ".json");
			String jsonTxt = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
			testData = new JSONObject(jsonTxt);
			System.out.println(testData.toString());
		} catch (IOException | JSONException e) {
			System.out.println("ERROR IN TESTDATA/JSON.");
			e.printStackTrace();
			
		}
	}

//	// CONSTRUCTOR:
//	TestData(Database db, String brandName, String scriptName) {
//		String json = db.getJSON(brandName, scriptName);
//		if (json != null) {
//			try {
//				testData = new JSONObject(json);
//			} catch (JSONException e) {
//				e.printStackTrace();
//			}
//			if (testData != null) {
//				System.out.println("Fetched test data for script: " + scriptName);
//			}
//		} else {
//			System.out.println("No JSON found.");
//		}
//	}

	// ---------------------------------------------------------------

	private final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
	private final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
	Random rand = new Random();
	StringBuilder builder;

	public String createRandomString(int length) {
		builder = new StringBuilder();
		for (int i = 1; i <= length; i++) {
			if (i == 1) {
				builder.append(CHAR_UPPER.charAt(rand.nextInt(26)));
			} else {
				builder.append(CHAR_LOWER.charAt(rand.nextInt(26)));
			}
		}
		return builder.toString();
	}// Closing CreateRandomString method

	// ------------------------------------------------------------------
	// GET VALUE FROM JSON
	public String getTestData(String key) {
		String value = null;
		try {

			// SPLIT KEYS WRT '.'
			String[] keyArr = key.split("\\.");

			JSONObject obj = testData;

			// REACH TILL FINAL JSON OBJECT
			if (keyArr.length > 1) {
				for (int i = 0; i < keyArr.length - 1; i++) {
					obj = obj.getJSONObject(keyArr[i]);
				}
			}
			// GET VALUE ACCORDING TO KEY
			value = obj.getString(keyArr[keyArr.length - 1]);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(value==null) {
			throw new NullPointerException("Value for '"+key+"' is unavailable in test data.");
		}

		return value;
	}

	// ---------------------------------------------------------------------
	// GET DATE AS REQUIRED:

	public String getDate(int offSet) {

		// NO. OF MILLI-SECONDS IN A DAY
		long DAY_IN_MS = 1000 * 60 * 60 * 24;

		// GETTING DATE ACCORDING TO OFFSET
		Date myDate = new Date(System.currentTimeMillis() + (offSet * DAY_IN_MS));

		// CHANGING THE FORMAT OF THE DATE
		SimpleDateFormat reqDate = new SimpleDateFormat("MM/dd/yyyy");

		// RETURNING DATE IN STRING
		return reqDate.format(myDate);
	}

	public String addDaystoDate(String date) {
		SimpleDateFormat reqDate = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		try {
			// Setting the date to the given date
			c.setTime(reqDate.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Number of Days to add
		c.add(Calendar.DAY_OF_MONTH, 2);
		// Date after adding the days to the given date
		String newDate = reqDate.format(c.getTime());
		// Displaying the new Date after addition of Days
		// System.out.println("Date after Addition: "+newDate);
		return newDate;
	}
	// ---------------------------------------------------------------------

	public String lessDaystoDate(String date) {
		SimpleDateFormat reqDate = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		try {
			// Setting the date to the given date
			c.setTime(reqDate.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Number of Days to add
		c.add(Calendar.DAY_OF_MONTH, -2);
		// Date after adding the days to the given date
		String newDate = reqDate.format(c.getTime());
		// Displaying the new Date after addition of Days
		// System.out.println("Date after Addition: "+newDate);
		return newDate;
	}
	// ---------------------------------------------------------------------
}// Closing CLASS
