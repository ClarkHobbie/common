package com.ltsllc.commons.application;

/**
 * A command line application.
 *
 * An application consists of a {@link CommandLine}.  Subclasses must implement
 * {@link #createCommandLine(String[])} in order to be instantiable.
 */
abstract public class Application {
    /**
     * Create an instance of {@link CommandLine} from the arguments passed to
     * the method.  Subclasses must implement this method to be instantiable.
     *
     * @param argv The arguments passed to the method.
     * @return The instance of {@link CommandLine} for this application.
     */
    abstract public CommandLine createCommandLine (String[] argv);

    private CommandLine commandLine;

    public Application (String[] argv) {
        CommandLine commandLine = createCommandLine(argv);
        setCommandLine(commandLine);
    }

    public CommandLine getCommandLine() {
        return commandLine;
    }

    public void setCommandLine(CommandLine commandLine) {
        this.commandLine = commandLine;
    }

    public void go () {
        getCommandLine().parse();
    }
}
