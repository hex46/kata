package fr.hex46.kata.bankaccount;

enum Action {
  DEPOSIT,
  WITHDRAWAL;

  public String getStringFormat() {
    return this == Action.DEPOSIT ? "%s || %s || || %s" : "%s || || %s || %s";
  }
}
