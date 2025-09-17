package com.strings;

public class ExcelSheetSolumnTitle {

	public static void main(String[] args) {
		String s = new ExcelSheetSolumnTitle().convertToTitle(704);
		System.out.println(s);
	}

	public String convertToTitle(int columnNumber) {

		if (columnNumber <= 0) {
			return "";
		}
		
		int a = columnNumber % 26;
		char s = (char) (64 + (a == 0 ? 26 : a));
		return convertToTitle(--columnNumber / 26) + s;
	}

}