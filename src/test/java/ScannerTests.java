import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import xyz.ventosa.lox.Scanner;
import xyz.ventosa.lox.TokenType;

public class ScannerTests {

    @Test
    public void givenEmptySource_whenScanning_onlyEOFToken() {
        Scanner scanner = new Scanner("");

        var thing = scanner.scanTokens();
        Assertions.assertEquals(1, thing.size());
        Assertions.assertEquals(TokenType.EOF, thing.get(0).getType());
    }

    @Test
    public void givenSourceWithNumber_whenScanning_getNumber() {
        Scanner scanner = new Scanner("123");

        var thing = scanner.scanTokens();
        Assertions.assertEquals(2, thing.size());
        Assertions.assertEquals(TokenType.NUMBER, thing.get(0).getType());
    }

    @Test
    public void givenSourceWithIdentifier_whenScanning_getIdentifier() {
        Scanner scanner = new Scanner("hello");

        var thing = scanner.scanTokens();
        Assertions.assertEquals(2, thing.size());
        Assertions.assertEquals(TokenType.IDENTIFIER, thing.get(0).getType());
    }
}