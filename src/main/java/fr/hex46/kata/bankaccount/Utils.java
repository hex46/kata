package fr.hex46.kata.bankaccount;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.format.DateTimeFormatter;

public class Utils {

  public static final String DOUBLE_PATTERN = "0.00";
  private static final String DATE_PATTERN = "dd/MM/yyyy";

  public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

  private static final DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance();
  static {
    decimalFormatSymbols.setDecimalSeparator('.');
  }
  public static final DecimalFormat decimalFormat = new DecimalFormat(DOUBLE_PATTERN, decimalFormatSymbols);
}
