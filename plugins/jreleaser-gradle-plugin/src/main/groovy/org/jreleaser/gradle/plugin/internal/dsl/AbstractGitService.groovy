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
package org.jreleaser.gradle.plugin.internal.dsl

import groovy.transform.CompileStatic
import org.gradle.api.internal.provider.Providers
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Internal
import org.jreleaser.gradle.plugin.dsl.GitService

import javax.inject.Inject

/**
 *
 * @author Andres Almiray
 * @since 0.1.0
 */
@CompileStatic
abstract class AbstractGitService implements GitService {
    final Property<String> repoHost
    final Property<String> repoOwner
    final Property<String> repoName
    final Property<String> repoUrlFormat
    final Property<String> commitUrlFormat
    final Property<String> downloadUrlFormat
    final Property<String> releaseNotesUrlFormat
    final Property<String> latestReleaseUrlFormat
    final Property<String> issueTrackerUrlFormat
    final Property<String> authorization
    final Property<String> tagName
    final Property<String> releaseName
    final Property<String> apiEndpoint
    final Property<Boolean> overwrite
    final Property<Boolean> allowUploadToExisting

    @Inject
    AbstractGitService(ObjectFactory objects) {
        repoHost = objects.property(String).convention(Providers.notDefined())
        repoOwner = objects.property(String).convention(Providers.notDefined())
        repoName = objects.property(String).convention(Providers.notDefined())
        repoUrlFormat = objects.property(String).convention(Providers.notDefined())
        commitUrlFormat = objects.property(String).convention(Providers.notDefined())
        downloadUrlFormat = objects.property(String).convention(Providers.notDefined())
        releaseNotesUrlFormat = objects.property(String).convention(Providers.notDefined())
        latestReleaseUrlFormat = objects.property(String).convention(Providers.notDefined())
        issueTrackerUrlFormat = objects.property(String).convention(Providers.notDefined())

        authorization = objects.property(String).convention(Providers.notDefined())
        tagName = objects.property(String).convention(Providers.notDefined())
        releaseName = objects.property(String).convention(Providers.notDefined())
        apiEndpoint = objects.property(String).convention(Providers.notDefined())
        overwrite = objects.property(Boolean).convention(false)
        allowUploadToExisting = objects.property(Boolean).convention(false)
    }

    @Internal
    boolean isSet() {
        repoHost.present ||
            repoOwner.present ||
            repoName.present ||
            repoUrlFormat.present ||
            commitUrlFormat.present ||
            downloadUrlFormat.present ||
            releaseNotesUrlFormat.present ||
            latestReleaseUrlFormat.present ||
            issueTrackerUrlFormat.present ||
            authorization.present ||
            tagName.present ||
            releaseName.present ||
            apiEndpoint.present ||
            overwrite.present ||
            allowUploadToExisting.present
    }

    protected void toModel(org.jreleaser.model.GitService service) {
        service.repoHost = repoHost.orNull
        service.repoOwner = repoOwner.orNull
        service.repoName = repoName.orNull
        service.repoUrlFormat = repoUrlFormat.orNull
        service.commitUrlFormat = commitUrlFormat.orNull
        service.downloadUrlFormat = downloadUrlFormat.orNull
        service.releaseNotesUrlFormat = releaseNotesUrlFormat.orNull
        service.latestReleaseUrlFormat = latestReleaseUrlFormat.orNull
        service.issueTrackerUrlFormat = issueTrackerUrlFormat.orNull
        service.authorization = authorization.orNull
        service.tagName = tagName.orNull
        service.releaseName = releaseName.orNull
        service.overwrite = overwrite.get()
        service.allowUploadToExisting = allowUploadToExisting.get()
        service.apiEndpoint = apiEndpoint.orNull
    }
}