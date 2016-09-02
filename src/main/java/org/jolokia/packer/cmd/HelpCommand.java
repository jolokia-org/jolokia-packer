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

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import org.springframework.stereotype.Component;

/**
 * @author roland
 * @since 01/09/16
 */
@Component
public class HelpCommand extends SubCommand {

    @Override
    protected String[] shouldRun(String[] args) {
        if (args.length == 0 || args[0].matches("--?h(elp)?")) {
            return new String[0];
        } else {
            return super.shouldRun(args);
        }
    }

    @Override
    protected String getName() {
        return "help";
    }

    @Override
    protected OptionParser getOptionParser() {
        return new OptionParser();
    }

    @Override
    protected void execute(OptionSet options) {
        System.out.println("jolokia-packer <sub-command> <options>");
    }
}
