package com.other;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.google.gson.Gson;

public class PDFParserUtil {

	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\Gaganam Krishna\\Desktop\\JsonData\\GR4_1922_GRL-3.pdf");
			PDDocument document = PDDocument.load(file);
			PDFTextStripper pdfStripper = new PDFTextStripper();
			String text = pdfStripper.getText(document);

			// Extract data from text
			List<StudentRecord> records = extractData(text);

			// Convert records to JSON
            Gson gson = new Gson();
            String json = gson.toJson(records);

            // Save JSON to file
            String outputPath = "C:\\Users\\Gaganam Krishna\\Desktop\\JsonData\\file.json";
            try (FileWriter writer = new FileWriter(outputPath)) {
                writer.write(json);
            }

			document.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<StudentRecord> extractData(String text) {
		List<StudentRecord> records = new ArrayList<>();
		String[] lines = text.split("\\r?\\n");

		// Track if we have started parsing the columns
		boolean parsingColumns = false;

		// Regex pattern for matching Hall Ticket Number
		Pattern hallTicketPattern = Pattern.compile("\\d{10}");

		for (String line : lines) {
			// Ignore the first 5 lines
			if (!parsingColumns && line.trim().equals("General")) {
				parsingColumns = true;
				continue;
			}

			if (parsingColumns) {
				
				// Split the line into columns
				String[] columns = line.split("\\s+");
				if (columns.length >= 9) {
					// Assuming each column has a specific width
					String generalRank = columns[0];
					String hallTicketNumber = columns[1];
					String marksFor300 = columns[2];
					String gender = columns[3];
					String community = columns[4];
					String ews = columns[5];
					String ph = columns[6];
					String exServicemen = columns[7];
					String sports = columns[8];
					String localDistrict = columns[9];
					
					
					// Check if the hall ticket number matches the pattern
					Matcher matcher = hallTicketPattern.matcher(hallTicketNumber);
					if (matcher.find()) {
						// Create a new StudentRecord object
						StudentRecord record = new StudentRecord(generalRank, hallTicketNumber, marksFor300, gender,
								community, ews, ph, exServicemen, sports, localDistrict);
						records.add(record);
						
						System.out.println("Record Data : "+record.toJSON());
					}
				}
			}
		}
		return records;
	}
	
}
