package gradecapture;

import java.util.AbstractMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The regex defines two parenthesis groups, one for the student number, one for
 * the grade. The grade is separated form the rest by at least one space,
 * (.*\\s+), an further is either 10(.0)? or \\d(([.,]\\d)?).
 *
 * If there is a match, the first group (0) is the whole matched string. The
 * following groups are the matched parenthesis groups if any, in order of the
 * definition in the regex (1st group contains student number, 2nd group the
 * grade).
 *
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
public class GradeCapture {

    static final String REGEX = "^(\\d{7})" // start with student number
            + ".*" // anything in between
            + "\\s+" // separated by at least one space
            + "(10(\\.0)?|\\d([.,]\\d)?)" // 10(.0)? or one digit and optionally comma or period followed one digits.
            + "$"; // and nothing else
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private final Matcher matcher;

    /**
     * Construct a GradeCapture from a string (line).
     *
     * @param line to read
     */
    public GradeCapture(String line) {
        matcher = PATTERN.matcher(line);
    }

    /**
     * Create a tupple. Use AbstractMap. SimpleEntry as implementing class.
     *
     * @return the tupple.
     */
    public AbstractMap.SimpleEntry<Integer, Double> getResult() {
        return new AbstractMap.SimpleEntry<>(studentId(), grade());
    }

    /**
     * Does the line contain the required data?
     *
     * @return whether there is a match
     */
    public boolean hasResult() {
        //TODO implement hasResult()
        return false;
    }
    //</editor-fold>

    /**
     * Get the grade, if any. Make sure to replace ','(comma) by . (period),
     * before you try to get the double value of the string.
     *
     * @return the grade or null
     */
    public Double grade() {
        //TODO implement grade()
        return 0.0D;
    }

    /**
     * Get the student id, if any.
     *
     * @return the student id or null when no match.
     */
    public Integer studentId() {
        //TODO implement studentId()
        return 0;
    }
    
    
}
