package fr.hex46.kata.bankaccount;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

class Account {

  private final Deque<Statement> statementStack = new ArrayDeque<>();

  public void addStatement(final Double amount, final LocalDate date, final Action action) {
    Double balance = this.calculateBalance(amount, action, this.getBalance());
    this.statementStack.push(new Statement(amount, date, action, balance));
  }

  private Double calculateBalance(final Double amount, final Action action, final Double currentBalance) {
    return action == Action.DEPOSIT ? currentBalance + amount : currentBalance - amount;
  }

  public Statement getLastStatement() {
    return this.statementStack.getFirst();
  }

  public Double getBalance() {
    return this.statementStack.isEmpty() ? 0D : this.statementStack.getFirst().balance();
  }

  @Override
  public String toString() {
    final String header = "date || credit || debit || balance";
    return header
        + "\n"
        + this.statementStack.stream()
            .map(Statement::toString)
            .collect(Collectors.joining("\n"));
  }
}
