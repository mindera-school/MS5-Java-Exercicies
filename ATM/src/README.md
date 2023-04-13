# ATM Program

This program simulates a basic ATM (Automated Teller Machine) where the user can perform some operations related to their account such as deposit, withdraw and check the movements.

## How to Use

1. Open the Java file in an IDE or text editor
2. Compile the Java file
3. Run the Java program

Once you run the program, you will be prompted to enter your password. Then, you will be given a list of options to choose from:

1. Deposit
2. Withdraw
3. Check Movement's
4. Quit

If you choose to deposit, you will be prompted to enter the amount you want to deposit. If you choose to withdraw, you will be prompted to enter the amount you want to withdraw. If you choose to check movements, you will see a list of all the movements that were made in the account.

## Classes

### ATM Class

This is the main class of the program. It contains the `main()` method and the `doOperations()` method.

### Card Class

This class represents a card that is linked to a bank account. It contains methods for checking the code, depositing money, withdrawing money, and checking the movements.

### ATMException Class

This is a custom exception that is thrown when an ATM operation fails. It is used to handle exceptions related to the card and the account.

## Disclaimer

This program is for educational purposes only and should not be used in any real-life ATM machine. It is not intended to be a complete implementation of an ATM system and should not be used as such.
