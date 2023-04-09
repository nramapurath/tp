package seedu.medinfo.logic.parser;

import static seedu.medinfo.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.medinfo.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.jupiter.api.Test;

import seedu.medinfo.logic.commands.FindCommand;

public class FindCommandParserTest {

    private FindCommandParser parser = new FindCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    //    @Test
    //    public void parse_validArgs_returnsFindCommand() {
    //        // no leading and trailing whitespaces
    //        FindCommand expectedFindCommand =
    //                new FindCommand(new NameContainsKeywordsPredicate(Arrays.asList("Alice", "Bob")));
    //        assertParseSuccess(parser, "Alice Bob", expectedFindCommand);
    //
    //        // multiple whitespaces between keywords
    //        assertParseSuccess(parser, " \n Alice \n \t Bob  \t", expectedFindCommand);
    //    }
}
