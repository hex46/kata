package fr.hex46.kata.bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

  @Test
  void should_save_date_and_deposit() {
    final Account account = new Account();

    account.addStatement(1000D, LocalDate.of(2012, 1, 10), Action.DEPOSIT);
    final Statement statement = account.getLastStatement();

    assertEquals(1000D, statement.amount());
    assertEquals(LocalDate.of(2012, 1, 10), statement.date());
  }

  @Test
  void should_calculate_balance() {
    final Account account = new Account();

    account.addStatement(1000D, LocalDate.of(2012, 1, 10), Action.DEPOSIT);
    account.addStatement(2000D, LocalDate.of(2012, 1, 13), Action.DEPOSIT);

    assertEquals(3000D, account.getBalance());
  }

  @Test
  void should_manage_withdrawal() {
    final Account account = new Account();

    account.addStatement(1000D, LocalDate.of(2012, 1, 10), Action.DEPOSIT);
    account.addStatement(2000D, LocalDate.of(2012, 1, 13), Action.DEPOSIT);
    account.addStatement(500D, LocalDate.of(2012, 1, 14), Action.WITHDRAWAL);

    assertEquals(2500D, account.getBalance());
  }

  @Test
  void should_print_deposit() {
    final Account account = new Account();

    account.addStatement(1000D, LocalDate.of(2012, 1, 10), Action.DEPOSIT);
    Statement statement = account.getLastStatement();

    assertEquals("10/01/2012 || 1000.00 || || 1000.00", statement.toString());
  }

  @Test
  void should_print_withdrawal() {
    final Account account = new Account();

    account.addStatement(500D, LocalDate.of(2012, 1, 14), Action.WITHDRAWAL);
    Statement statement = account.getLastStatement();

    assertEquals("14/01/2012 || || 500.00 || -500.00", statement.toString());
  }

  @Test
  void should_print_account_with_header() {
    final Account account = new Account();

    account.addStatement(1000D, LocalDate.of(2012, 1, 10), Action.DEPOSIT);

    final String expected = """
date || credit || debit || balance
10/01/2012 || 1000.00 || || 1000.00""";

    assertEquals(expected, account.toString());
  }

  @Test
  void should_print_account() {
    final Account account = new Account();

    account.addStatement(1000D, LocalDate.of(2012, 1, 10), Action.DEPOSIT);
    account.addStatement(2000D, LocalDate.of(2012, 1, 13), Action.DEPOSIT);
    account.addStatement(500D, LocalDate.of(2012, 1, 14), Action.WITHDRAWAL);

    final String expected = """
date || credit || debit || balance
14/01/2012 || || 500.00 || 2500.00
13/01/2012 || 2000.00 || || 3000.00
10/01/2012 || 1000.00 || || 1000.00""";

    assertEquals(expected, account.toString());
  }
}
