import java.awt.Color;
import java.awt.Font;

public class Theme {

    // Colors
    public static final Color PRIMARY = new Color(37, 99, 235);
    public static final Color PRIMARY_DARK = new Color(29, 78, 216);
    public static final Color BACKGROUND = Color.WHITE;
    public static final Color PANEL = new Color(248, 250, 252);
    public static final Color TEXT = new Color(31, 41, 55);
    public static final Color SUBTEXT = new Color(107, 114, 128);

    // Fonts
    public static final Font TITLE_FONT =
            new Font("Segoe UI", Font.BOLD, 28);

    public static final Font SUBTITLE_FONT =
            new Font("Segoe UI", Font.PLAIN, 14);

    public static final Font LABEL_FONT =
            new Font("Segoe UI", Font.PLAIN, 14);

    public static final Font BUTTON_FONT =
            new Font("Segoe UI", Font.BOLD, 15);

    public static final Font INPUT_FONT =
            new Font("Segoe UI", Font.PLAIN, 14);

    private Theme() {
        // Prevent instantiation
    }
}