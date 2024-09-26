package micromarine;
import java.sql.Connection;
import java.sql.SQLException;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;
import javafx.scene.control.Button;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class AppTest extends ApplicationTest{
//     @Test
//  public void testForm() {
// System.out.println("THANKS FOR SUBMITTING YOUR DATA!");
// String str1="THANKS FOR SUBMITTING YOUR DATA!";
// assertEquals("THANKS FOR SUBMITTING YOUR DATA!", str1);
//  }



    private static final String USER = "mmuser";
    private static final String PASSWORD = "N14llsqf5077!";
    private static final String URL = "jdbc:mysql://localhost:3306/micromarinedb";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private ConnectSQL connectSQL;

    @BeforeEach
    void setUp() {
        connectSQL = new ConnectSQL();
    }

    @Test
    void testGetCon_SuccessfulConnection() {
        try (Connection con = ConnectSQL.GetCon()) {
            assertNotNull(con, "Connection should not be null");
            // Add more assertions if needed (e.g., check if the connection is open)
        } catch (SQLException e) {
            fail("Exception occurred while getting a connection: " + e.getMessage());
        }
    }

    @Test
    void testGetCon_DriverNotFoundException() {
        // Simulate driver not found
        ConnectSQL.driver = "invalid.driver.class.name";
        assertThrows(RuntimeException.class, () -> ConnectSQL.GetCon());
    }

    @Test
    void testGetCon_SQLException() {
        // Simulate SQL exception (e.g., wrong credentials or invalid URL)
        ConnectSQL.user = "invalid_user";
        assertThrows(RuntimeException.class, () -> ConnectSQL.GetCon());
    }



}







