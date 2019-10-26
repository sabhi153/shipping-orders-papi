package com.lynnco.csv.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.input.BOMInputStream;

public class CSVUtils {
	private CSVFormat format;

	public CSVUtils(CSVFormat csvFormat) {
		super();
		this.format = csvFormat;
		// TODO Auto-generated constructor stub
	}

	public static CSVFormat getCSVFormat(String headers) {

		return CSVFormat.DEFAULT.withHeader(headers).withTrim();
	}

	public static String[] getHeaders(CSVFormat format) {
		return format.getHeader();
	}

	public static Object getValue(CSVRecord record, String columnName) {
		return record.get(columnName);
	}

	public static void dumpCSVRecord(Object record) {
		System.out.println(record);
	}

	public final HashMap<String, Object> reader(InputStream is) throws IOException {
		HashMap<String, Object> readerParserMap = new HashMap<>();

		System.out.println("FOrmatter Properties : " + this.format.getHeader());

		final Reader reader = new InputStreamReader(new BOMInputStream(is), "UTF-8");
		final CSVParser parser = new CSVParser(reader, this.format);
		readerParserMap.put("reader", reader);
		readerParserMap.put("parser", parser);
		return readerParserMap;

	}

	public void closeAllResources(HashMap<String, Object> obj) throws IOException {

		
		
		if  (!((CSVParser)obj.get("parser")).isClosed()) {
			((CSVParser) obj.get("parser")).close();
		}

	}
}
