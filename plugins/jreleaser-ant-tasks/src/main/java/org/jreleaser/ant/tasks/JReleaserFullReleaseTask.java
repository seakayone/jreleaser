/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2020-2021 Andres Almiray.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jreleaser.ant.tasks;

import org.jreleaser.model.JReleaserContext;

import static org.jreleaser.ant.tasks.JReleaserAnnounceTask.announce;
import static org.jreleaser.ant.tasks.JReleaserChecksumTask.checksum;
import static org.jreleaser.ant.tasks.JReleaserPackageTask.packageTools;
import static org.jreleaser.ant.tasks.JReleaserPrepareTask.prepare;
import static org.jreleaser.ant.tasks.JReleaserReleaseTask.release;
import static org.jreleaser.ant.tasks.JReleaserSignTask.sign;
import static org.jreleaser.ant.tasks.JReleaserUploadTask.upload;

/**
 * @author Andres Almiray
 * @since 0.1.0
 */
public class JReleaserFullReleaseTask extends AbstractJReleaserTask {
    @Override
    protected void doExecute(JReleaserContext context) {
        checksum(context);
        sign(context);
        release(context);
        prepare(context, true);
        packageTools(context, true);
        upload(context, true);
        announce(context);
    }
}