package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CAPACITY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;


import java.util.stream.Stream;

import seedu.address.logic.commands.AddWardCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ward.Capacity;
import seedu.address.model.ward.Ward;
import seedu.address.model.ward.WardName;


/**
 * Parses input arguments and creates a new AddWardCommand object
 */
public class AddWardCommandParser implements Parser<AddWardCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddWardCommand
     * and returns an AddWardCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddWardCommand parse(String args) throws ParseException {

        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_CAPACITY);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddWardCommand.MESSAGE_USAGE));
        }

        if (!arePrefixesPresent(argMultimap, PREFIX_CAPACITY)) {
            WardName wardName = ParserUtil.parseWardName(argMultimap.getValue(PREFIX_NAME).get());
            Ward ward = new Ward(wardName);
            return new AddWardCommand(ward);
        }

        WardName wardName = ParserUtil.parseWardName(argMultimap.getValue(PREFIX_NAME).get());
        Capacity wardCapacity = ParserUtil.parseCapacity(argMultimap.getValue(PREFIX_CAPACITY).get());
        Ward ward = new Ward(wardName, wardCapacity);
        return new AddWardCommand(ward);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values
     * in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
