package fr.hex46.kata.bankaccount;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public record Statement(Double amount, LocalDate date, Action action, Double balance) {

  @Override
  public String toString() {
    return this.action.getStringFormat().formatted(
        this.date.format(Utils.dateTimeFormatter),
        Utils.decimalFormat.format(this.amount),
        Utils.decimalFormat.format(this.balance));
  }
}
