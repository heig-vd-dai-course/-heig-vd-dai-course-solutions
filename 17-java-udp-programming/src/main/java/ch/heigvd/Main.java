package ch.heigvd;

import ch.heigvd.commands.broadcast.Broadcast;
import ch.heigvd.commands.multicast.Multicast;
import ch.heigvd.commands.unicast.Unicast;
import lombok.Getter;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
        description = "Practical content of the Java UDP programming chapter",
        version = "1.0.0",
        subcommands = {Broadcast.class, Multicast.class, Unicast.class},
        scope = CommandLine.ScopeType.INHERIT,
        mixinStandardHelpOptions = true
)
@Getter
public class Main {

    public static void main(String... args) {
        // Source: https://stackoverflow.com/a/11159435
        String commandName = new java.io.File(
                Main.class.getProtectionDomain()
                        .getCodeSource()
                        .getLocation()
                        .getPath()
        ).getName();

        int exitCode = new CommandLine(new Main())
                .setCommandName(commandName)
                .execute(args);
        System.exit(exitCode);
    }
}
