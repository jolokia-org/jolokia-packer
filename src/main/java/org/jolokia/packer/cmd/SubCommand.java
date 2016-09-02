package org.jolokia.packer.cmd;
/*
 *
 * Copyright 2016 Roland Huss
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Arrays;

import joptsimple.OptionException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author roland
 * @since 01/09/16
 */
public abstract class SubCommand implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        String subArgs[] = shouldRun(args);
        if (subArgs != null) {
            OptionParser parser = getOptionParser();
            try {
                OptionSet options = parser.parse(subArgs);
                execute(options);
            } catch (OptionException exp) {
                System.err.println(String.format("Invalid option: %s",exp.getMessage()));
                System.exit(1);
            }
        }
    }

    protected String[] shouldRun(String[] args) {
        String subCommand = getName();
        if (args.length > 0 && args[0].equalsIgnoreCase(subCommand)) {
            return Arrays.asList(args).subList(1,args.length).toArray(new String[0]);
        } else {
            return null;
        }
    }

    protected abstract String getName();

    protected abstract OptionParser getOptionParser();

    protected abstract void execute(OptionSet options);

}
